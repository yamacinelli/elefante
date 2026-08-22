package com.elefante.backend.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.NonNull;

public record InviteRequest(
    @NotBlank @Email String email,
    @NotBlank @Min(8) String tmpPassword,
    @NotBlank @Min(3) String name,
    @NotBlank @Min(3) String lastName,
    @NonNull @Size(min = 11, max = 11) Integer identificationNumber,
    @NotBlank @Min(4) String role
) { }
