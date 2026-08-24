package com.elefante.backend.worklog;

import java.time.Instant;

import org.locationtech.jts.geom.Point;

import jakarta.validation.constraints.NotNull;

public record WorkLogClockRequest(
    Instant instant,
    Point coordinates,
    @NotNull Integer userId
) { }
