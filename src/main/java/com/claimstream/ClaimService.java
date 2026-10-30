package com.claimstream;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    @Transactional
    public ClaimResponse submitClaim(ClaimRequest request) {
        String claimId = UUID.randomUUID().toString();

        Claim claim = new Claim(
                claimId,
                request.policyNumber(),
                request.description(),
                "RECEIVED",
                Instant.now()
        );

        Claim savedClaim = claimRepository.save(claim);

        return new ClaimResponse(
                savedClaim.getClaimId(),
                savedClaim.getStatus(),
                "Claim received for policy " + savedClaim.getPolicyNumber()
        );
    }
}
