package com.elefante.backend.setup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SetupRequest(
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String password
) { }
