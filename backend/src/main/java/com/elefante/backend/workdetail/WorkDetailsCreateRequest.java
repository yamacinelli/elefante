package com.elefante.backend.workdetail;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record WorkDetailsCreateRequest(
    @NotBlank String workModel,
    @NotBlank String contractType,
    @NotNull Schedule schedule,
    @NotNull Integer jobId,
    @NotNull Integer branchId,
    @NotNull Integer userId
) {

    record Schedule(
        @NotNull Integer weeklyHours,
        @NotEmpty List<ShiftDetails> shiftDetails
    ) {

        record ShiftDetails(
            @NotBlank String dayOfWeek,
            @NotBlank
            @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$", message = "Time must be in HH:mm format (e.g. 07:30)")
            String startTime,
            @NotBlank
            @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d$", message = "Time must be in HH:mm format (e.g. 17:30)")
            String endTime,
            @NotNull Integer breakMinutes
        ) { }
    }
}
