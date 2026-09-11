package com.elefante.backend.attendancerecord;

import org.locationtech.jts.geom.Point;

import jakarta.validation.constraints.NotNull;

public record AttendanceRecordCreateRequest(
    Point coordinate,
    @NotNull Integer employeeId
) { }
