package com.claimstream;

import jakarta.validation.constraints.NotBlank;

public record ClaimRequest(
        @NotBlank String policyNumber,
        @NotBlank String description
) {
}
