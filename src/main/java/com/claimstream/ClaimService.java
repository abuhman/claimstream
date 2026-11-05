package com.claimstream;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimEventPublisher eventPublisher;

    public ClaimService(
            ClaimRepository claimRepository,
            ClaimEventPublisher eventPublisher
    ) {
        this.claimRepository = claimRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public ClaimResponse submitClaim(ClaimRequest request) {
        String claimId = UUID.randomUUID().toString();
        Instant submittedAt = Instant.now();

        Claim claim = new Claim(
                claimId,
                request.policyNumber(),
                request.description(),
                "RECEIVED",
                submittedAt
        );

        Claim savedClaim = claimRepository.save(claim);

        ClaimSubmittedEvent event = new ClaimSubmittedEvent(
                savedClaim.getClaimId(),
                savedClaim.getPolicyNumber(),
                submittedAt
        );

        eventPublisher.publish(event);

        return new ClaimResponse(
                savedClaim.getClaimId(),
                savedClaim.getStatus(),
                "Claim received for policy " + savedClaim.getPolicyNumber()
        );
    }
}
