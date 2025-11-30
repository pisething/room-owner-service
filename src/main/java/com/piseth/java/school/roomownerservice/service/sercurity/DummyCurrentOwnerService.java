package com.piseth.java.school.roomownerservice.service.sercurity;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class DummyCurrentOwnerService implements CurrentOwnerService {

    @Override
    public Mono<String> getCurrentOwnerId() {
        // For now: fixed owner or later from header X-Owner-Id
        return Mono.just("123");
    }
}
