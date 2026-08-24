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

    private Integer weeklyHours;

    private List<ShiftDetails> shiftDetails;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShiftDetails {

        private String dayOfWeek; // e.g., "MONDAY"

        private String startTime; // e.g., "07:30"

        private String endTime; // e.g., "17:30"

        private Integer breakMinutes;
    }
}
