package com.elefante.backend.setup;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SetupRequest(
    @NotBlank @Email String email,
    @NotBlank
    @Pattern(
        regexp = "^(?=(?:.*[!@#$%^&*()\\-_=+\\[\\]{};:'\",.<>/?\\\\|`~]){2,})(?=(?:.*\\d){2,}).{8,}$",
        message = "Password must be at least 8 characters, with at least 2 digits and 2 special characters"
    )
    String password
) { }
