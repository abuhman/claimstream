package com.claimstream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClaimServiceTest {

    private final ClaimService claimService = new ClaimService();

    @Test
    void submitClaimReturnsReceivedClaim() {
        ClaimRequest request = new ClaimRequest(
                "POL-10042",
                "Rear bumper damaged in a parking lot"
        );

        ClaimResponse response = claimService.submitClaim(request);

        assertNotNull(response.claimId());
        assertFalse(response.claimId().isBlank());
        assertEquals("RECEIVED", response.status());
        assertEquals(
                "Claim received for policy POL-10042",
                response.message()
        );
    }
}
