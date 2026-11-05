package com.claimstream.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClaimSubmittedConsumer {

    @KafkaListener(
        topics = "claims.submitted",
        groupId = "claimstream-processor"
    )
    public void consume(String message) {
        System.out.println("Received claim event: " + message);
    }
}
