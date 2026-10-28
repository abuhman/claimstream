package com.claimstream;

public record ClaimResponse(
        String claimId,
        String status,
        String message
) {
}
