package com.piseth.java.school.roomownerservice.service.photo;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TempFileService {

    public Mono<Path> writeToTempFile(final FilePart filePart) {
        return Mono.fromCallable(() -> Files.createTempFile("room-photo-", ".upload"))
                .flatMap(tmp -> filePart.transferTo(tmp).thenReturn(tmp));
    }

    public void safeDelete(final Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (Exception ex) {
            log.warn("Failed to delete temp file: {}", path);
        }
    }
}
