package com.piseth.java.school.roomownerservice.service.photo;

import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PhotoValidator {

    private final PhotoPolicy policy;

    public Mono<ValidatedPhoto> validate(final FilePart filePart) {
        String contentType = null;
        if (filePart.headers().getContentType() != null) {
            contentType = filePart.headers().getContentType().toString();
        }

        if (!StringUtils.hasText(contentType) || !policy.allowedContentTypes().contains(contentType)) {
            return Mono.error(new IllegalArgumentException("Only jpg, png, webp are allowed"));
        }

        String ext = contentTypeToExt(contentType);
        return Mono.just(new ValidatedPhoto(contentType, ext));
    }

    private String contentTypeToExt(final String contentType) {
        if ("image/jpeg".equals(contentType)) {
            return ".jpg";
        }
        if ("image/png".equals(contentType)) {
            return ".png";
        }
        if ("image/webp".equals(contentType)) {
            return ".webp";
        }
        return "";
    }

    public record ValidatedPhoto(String contentType, String extension) {
    }
}
