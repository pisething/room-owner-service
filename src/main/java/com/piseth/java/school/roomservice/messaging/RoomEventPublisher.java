package com.piseth.java.school.roomservice.messaging;

import com.piseth.java.school.roomservice.messaging.event.RoomEventEnvelope;
import reactor.core.publisher.Mono;

public interface RoomEventPublisher {
    Mono<Void> publish(String topic, String key, RoomEventEnvelope<?> envelope);
}
