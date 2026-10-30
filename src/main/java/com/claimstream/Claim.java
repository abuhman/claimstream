package com.claimstream;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "claims")
public class Claim {

    @Id
    private String claimId;

    @Column(nullable = false)
    private String policyNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Instant createdAt;

    protected Claim() {
        // Required by JPA
    }

    public Claim(
            String claimId,
            String policyNumber,
            String description,
            String status,
            Instant createdAt
    ) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
