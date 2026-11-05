package com.claimstream;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClaimEventPublisher {

    private static final String TOPIC = "claims.submitted";

    private final KafkaTemplate<String, ClaimSubmittedEvent> kafkaTemplate;

    public ClaimEventPublisher(
            KafkaTemplate<String, ClaimSubmittedEvent> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(ClaimSubmittedEvent event) {
        kafkaTemplate.send(TOPIC, event.claimId(), event);
    }
}
