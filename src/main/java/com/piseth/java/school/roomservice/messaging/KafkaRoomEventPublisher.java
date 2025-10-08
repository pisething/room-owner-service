package com.piseth.java.school.roomservice.messaging;

import java.nio.charset.StandardCharsets;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.piseth.java.school.roomservice.messaging.event.RoomEventEnvelope;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class KafkaRoomEventPublisher implements RoomEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public Mono<Void> publish(final String topic, final String key, final RoomEventEnvelope<?> envelope) {
        final ProducerRecord<String, Object> record = new ProducerRecord<>(topic, key, envelope);

        record.headers().add(new RecordHeader("eventId", envelope.getEventId().getBytes(StandardCharsets.UTF_8)));
        record.headers().add(new RecordHeader("eventType", envelope.getType().name().getBytes(StandardCharsets.UTF_8)));
        record.headers().add(new RecordHeader("eventVersion", envelope.getVersion().getBytes(StandardCharsets.UTF_8)));
        record.headers().add(new RecordHeader("producer", envelope.getProducer().getBytes(StandardCharsets.UTF_8)));

        if (envelope.getHeaders() != null) {
            envelope.getHeaders().forEach((k, v) -> {
                if (k != null && v != null) {
                    record.headers().add(new RecordHeader(k, v.getBytes(StandardCharsets.UTF_8)));
                }
            });
        }

        return Mono.fromFuture(() -> kafkaTemplate.send(record).completable()).then();
    }
}
