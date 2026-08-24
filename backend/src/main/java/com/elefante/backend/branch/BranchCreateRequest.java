package com.elefante.backend.branch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BranchCreateRequest(
    @NotBlank String name,
    @NotBlank @Size(min = 14, max = 14) String registrationNumber
) { }
