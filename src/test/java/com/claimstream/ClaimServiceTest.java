package com.claimstream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClaimServiceTest {

    @Mock
    private ClaimRepository claimRepository;

    @InjectMocks
    private ClaimService claimService;

    @Test
    void submitClaimSavesClaimAndReturnsResponse() {
        ClaimRequest request = new ClaimRequest(
                "POL-10042",
                "Rear bumper damaged in a parking lot"
        );

        when(claimRepository.save(any(Claim.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        ClaimResponse response = claimService.submitClaim(request);

        assertNotNull(response.claimId());
        assertEquals("RECEIVED", response.status());
        assertEquals(
                "Claim received for policy POL-10042",
                response.message()
        );

        verify(claimRepository).save(any(Claim.class));
    }
}
