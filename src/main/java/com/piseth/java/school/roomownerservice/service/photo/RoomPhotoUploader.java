package com.piseth.java.school.roomownerservice.service.photo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;

import com.piseth.java.school.roomownerservice.storage.ObjectStorage;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RoomPhotoUploader {

    private final PhotoPolicy policy;
    private final PhotoValidator validator;
    private final TempFileService tempFileService;
    private final ObjectStorage objectStorage;

    public Mono<String> uploadOne(final String roomId, final FilePart filePart) {
        return validator.validate(filePart)
                .flatMap(valid -> tempFileService.writeToTempFile(filePart)
                        .flatMap(tmp -> validateSize(tmp)
                                .flatMap(ignored -> putObject(roomId, tmp, valid))
                                .doFinally(sig -> tempFileService.safeDelete(tmp))
                        )
                );
    }

    private Mono<Long> validateSize(final Path tmp) {
        return Mono.fromCallable(() -> Files.size(tmp))
                .flatMap(size -> {
                    if (size > policy.maxFileSizeBytes()) {
                        return Mono.error(new IllegalArgumentException(
                                "File too large. Max=" + policy.maxFileSizeBytes() + " bytes"
                        ));
                    }
                    return Mono.just(size);
                });
    }

    private Mono<String> putObject(final String roomId, final Path tmp, final PhotoValidator.ValidatedPhoto valid) {
        String objectKey = "rooms/" + roomId + "/" + UUID.randomUUID() + valid.extension();
        return objectStorage.putObject(objectKey, valid.contentType(), tmp)
                .thenReturn(objectKey);
    }
}
