package com.elefante.backend.job;

public record JobResponse(
    Integer id,
    String name,
    Boolean isEnabled
) { }
