package com.piseth.java.school.roomownerservice.storage;

import java.time.Duration;

import reactor.core.publisher.Mono;

public interface ObjectStorage {

    Mono<Void> putObject(String objectKey, String contentType, java.nio.file.Path filePath);

    Mono<Void> removeObject(String objectKey);

    Mono<String> presignedGetUrl(String objectKey, Duration expiry);
}
