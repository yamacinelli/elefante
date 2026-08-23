package com.elefante.backend.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
    @NotNull Integer id,
    @Email String email,
    @Size(min = 8) String password,
    @Size(min = 4) String role
) { }
