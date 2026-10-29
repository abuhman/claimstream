package com.claimstream;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ClaimService {

    public ClaimResponse submitClaim(ClaimRequest request) {
        String claimId = UUID.randomUUID().toString();

        return new ClaimResponse(
                claimId,
                "RECEIVED",
                "Claim received for policy " + request.policyNumber()
        );
    }
}
