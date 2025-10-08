// src/main/java/com/piseth/java/school/roomservice/outbox/OutboxRepository.java
package com.piseth.java.school.roomservice.outbox;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface OutboxRepository extends ReactiveMongoRepository<OutboxEvent, String> {

    Flux<OutboxEvent> findByStatusAndAvailableAtLessThanEqualOrderByOccurredAtAsc(
            OutboxStatus status, LocalDateTime availableAt, Pageable pageable);
}
