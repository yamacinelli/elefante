package com.elefante.backend.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SignInRequest(
    @NotBlank @Email String email,
    @NotBlank @Min(8) String password
) { }
