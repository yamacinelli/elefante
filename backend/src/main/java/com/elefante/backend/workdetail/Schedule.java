package com.elefante.backend.workdetail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {

    @JsonProperty("weekly_hours")
    private Integer weeklyHours;

    @JsonProperty("shift_schedules")
    private List<ShiftDetails> shiftSchedules;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShiftDetails {

        @JsonProperty("day_of_week")
        private String dayOfWeek; // e.g., "MONDAY"

        @JsonProperty("start_time")
        private String startTime; // e.g., "07:30"

        @JsonProperty("end_time")
        private String endTime; // e.g., "17:30"

        @JsonProperty("break_minutes")
        private Integer breakMinutes;
    }
}
