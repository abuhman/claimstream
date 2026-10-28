package com.claimstream;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClaimResponse submitClaim(
            @Valid @RequestBody ClaimRequest request
    ) {
        String claimId = UUID.randomUUID().toString();

        return new ClaimResponse(
                claimId,
                "RECEIVED",
                "Claim received for policy " + request.policyNumber()
        );
    }
}
