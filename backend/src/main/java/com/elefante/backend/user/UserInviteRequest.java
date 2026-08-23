package com.elefante.backend.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserInviteRequest(
    @NotBlank @Email String email,
    @NotBlank @Size(min = 8) String tmpPassword,
    @NotBlank @Size(min = 3) String name,
    @NotBlank @Size(min = 3) String lastName,
    @NotNull @Size(min = 11, max = 11) Integer identificationNumber,
    @NotBlank @Size(min = 4) String role
) { }
