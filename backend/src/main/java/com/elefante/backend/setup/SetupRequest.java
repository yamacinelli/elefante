package com.elefante.backend.setup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SetupRequest(
    @NotBlank @Email String email,
    @NotBlank @Min(8) String password
) { }
