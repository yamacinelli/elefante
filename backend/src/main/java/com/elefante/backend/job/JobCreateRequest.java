package com.elefante.backend.job;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record JobCreateRequest(
    @NotNull @Size(min = 4) String name
) { }
