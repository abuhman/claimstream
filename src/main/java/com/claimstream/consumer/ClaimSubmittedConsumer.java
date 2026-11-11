package com.claimstream.consumer;

import com.claimstream.ClaimSubmittedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClaimSubmittedConsumer {

    @KafkaListener(
        topics = "claims.submitted",
        groupId = "claimstream-processor"
    )
    public void consume(ClaimSubmittedEvent event) {
        System.out.println("Received claim event:");
        System.out.println("Claim ID: " + event.claimId());
        System.out.println("Policy Number: " + event.policyNumber());
        System.out.println("Submitted At: " + event.submittedAt());
    }
}
