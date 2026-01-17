package com.piseth.java.school.roomownerservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import com.piseth.java.school.roomownerservice.dto.RoomResponse;
import com.piseth.java.school.roomownerservice.exception.RoomNotFoundException;
import com.piseth.java.school.roomownerservice.repository.RoomRepository;
import com.piseth.java.school.roomownerservice.service.RoomMediaService;
import com.piseth.java.school.roomownerservice.service.access.RoomAccessService;
import com.piseth.java.school.roomownerservice.service.photo.PhotoPolicy;
import com.piseth.java.school.roomownerservice.service.photo.RoomPhotoUploader;
import com.piseth.java.school.roomownerservice.service.photo.RoomPhotoUrlService;
import com.piseth.java.school.roomownerservice.storage.ObjectStorage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomMediaServiceImpl implements RoomMediaService {

    private final RoomRepository roomRepository;

    private final RoomAccessService accessService;
    private final PhotoPolicy photoPolicy;

    private final RoomPhotoUploader uploader;
    private final RoomPhotoUrlService photoUrlService;

    private final ObjectStorage objectStorage;

    @Override
    public Mono<RoomResponse> uploadRoomPhotos(final String roomId,
                                              final String ownerId,
                                              final Flux<FilePart> files) {

        return roomRepository.findById(roomId)
                .switchIfEmpty(Mono.error(new RoomNotFoundException(roomId)))
                .flatMap(room -> {
                    accessService.assertOwner(room, ownerId);

                    int existing = Optional.ofNullable(room.getPhotoObjectKeys()).map(List::size).orElse(0);
                    int maxFiles = photoPolicy.maxFilesPerRoom();

                    return files.switchIfEmpty(Mono.error(new IllegalArgumentException("files is required")))
                            .flatMap(file -> uploader.uploadOne(roomId, file), 3)
                            .collectList()
                            .flatMap(uploadedKeys -> {
                                if (existing + uploadedKeys.size() > maxFiles) {
                                    return cleanup(uploadedKeys)
                                            .then(Mono.error(new IllegalArgumentException("Too many photos. Max=" + maxFiles)));
                                }

                                List<String> merged = new ArrayList<>(
                                        Optional.ofNullable(room.getPhotoObjectKeys()).orElse(List.of())
                                );
                                merged.addAll(uploadedKeys);
                                room.setPhotoObjectKeys(merged);

                                return roomRepository.save(room)
                                        .onErrorResume(ex -> cleanup(uploadedKeys).then(Mono.error(ex)));
                            })
                            .flatMap(photoUrlService::toRoomResponseWithUrls)
                            .doOnSuccess(r -> log.info("Uploaded photos roomId={}, count={}",
                                    roomId, r.getPhotoUrls() == null ? 0 : r.getPhotoUrls().size()))
                            .doOnError(ex -> log.error("Upload photos failed roomId={}, err={}", roomId, ex.getMessage(), ex));
                });
    }

    @Override
    public Mono<RoomResponse> getRoomWithPhotoUrls(final String roomId, final String ownerId) {
        return roomRepository.findById(roomId)
                .switchIfEmpty(Mono.error(new RoomNotFoundException(roomId)))
                .flatMap(room -> {
                    accessService.assertOwner(room, ownerId);
                    return photoUrlService.toRoomResponseWithUrls(room);
                });
    }

    @Override
    public Mono<RoomResponse> deleteRoomPhoto(final String roomId, final String ownerId, final String objectKey) {
        return roomRepository.findById(roomId)
                .switchIfEmpty(Mono.error(new RoomNotFoundException(roomId)))
                .flatMap(room -> {
                    accessService.assertOwner(room, ownerId);

                    List<String> keys = new ArrayList<>(
                            Optional.ofNullable(room.getPhotoObjectKeys()).orElse(List.of())
                    );

                    boolean removed = keys.remove(objectKey);
                    if (!removed) {
                        return photoUrlService.toRoomResponseWithUrls(room); // idempotent
                    }

                    room.setPhotoObjectKeys(keys);

                    return roomRepository.save(room)
                            .flatMap(saved -> objectStorage.removeObject(objectKey).thenReturn(saved))
                            .flatMap(photoUrlService::toRoomResponseWithUrls);
                });
    }

    private Mono<Void> cleanup(final List<String> objectKeys) {
        return Flux.fromIterable(objectKeys)
                .flatMap(objectStorage::removeObject)
                .then();
    }
}
