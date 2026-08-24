package com.elefante.backend.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserInviteRequest(
    @NotBlank @Email String email,
    @NotBlank @Pattern(
        regexp = "^(?=(?:.*[!@#$%^&*()\\-_=+\\[\\]{};:'\",.<>/?\\\\|`~]){2,})(?=(?:.*\\d){2,}).{8,}$",
        message = "Password must be at least 8 characters, with at least 2 digits and 2 special characters"
    )
    String tmpPassword,
    @NotBlank @Size(min = 3) String name,
    @NotBlank @Size(min = 3) String lastName,
    @NotNull @Pattern(regexp = "\\d{11}", message = "Identification number must be exactly 11 digits")
    String identificationNumber,
    @NotBlank @Size(min = 4) String role
) { }
