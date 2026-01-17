package com.piseth.java.school.roomownerservice.service.photo;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.piseth.java.school.roomownerservice.config.MinioProperties;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PhotoPolicy {

    private static final Set<String> ALLOWED_CONTENT_TYPES = Set.of(
            "image/jpeg", "image/png", "image/webp"
    );

    private final MinioProperties props;

    public Set<String> allowedContentTypes() {
        return ALLOWED_CONTENT_TYPES;
    }

    public int maxFilesPerRoom() {
        Integer value = props.maxFilesPerRoom();
        return value != null ? value : 10;
    }

    public long maxFileSizeBytes() {
        Long value = props.maxFileSizeBytes();
        return value != null ? value : 5_000_000L;
    }
}
