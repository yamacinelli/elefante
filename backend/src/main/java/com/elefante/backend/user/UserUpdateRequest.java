package com.elefante.backend.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
    @NotNull Integer id,
    @Email String email,
    @Pattern(
        regexp = "^(?=(?:.*[!@#$%^&*()\\-_=+\\[\\]{};:'\",.<>/?\\\\|`~]){2,})(?=(?:.*\\d){2,}).{8,}$",
        message = "Password must be at least 8 characters, with at least 2 digits and 2 special characters"
    )
    String password,
    @Size(min = 4) String role
) { }
