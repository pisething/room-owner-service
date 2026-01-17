package com.piseth.java.school.roomownerservice.service.photo;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.piseth.java.school.roomownerservice.domain.Room;
import com.piseth.java.school.roomownerservice.dto.RoomResponse;
import com.piseth.java.school.roomownerservice.mapper.RoomMapper;
import com.piseth.java.school.roomownerservice.storage.ObjectStorage;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RoomPhotoUrlService {

    private final RoomMapper roomMapper;
    private final ObjectStorage objectStorage;

    public Mono<RoomResponse> toRoomResponseWithUrls(final Room room) {
        RoomResponse resp = roomMapper.toResponse(room);

        List<String> keys = Optional.ofNullable(room.getPhotoObjectKeys()).orElse(List.of());

        return Flux.fromIterable(keys)
                .flatMap(key -> objectStorage.presignedGetUrl(key, Duration.ofHours(6)), 5)
                .collectList()
                .map(urls -> {
                    resp.setPhotoUrls(urls);
                    return resp;
                });
    }
}
