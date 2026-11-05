package com.claimstream;

import java.time.Instant;

public record ClaimSubmittedEvent(
        String claimId,
        String policyNumber,
        Instant submittedAt
) {
}
