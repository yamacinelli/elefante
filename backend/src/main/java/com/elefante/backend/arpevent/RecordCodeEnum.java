package com.elefante.backend.arpevent;

public enum RecordCodeEnum {

    EMPLOYER_DATA_MANIPULATION(2),
    EMPLOYEE_DATA_MANIPULATION(5),
    SENSITIVE(6),
    TIME_RECORD(7);

    private Integer value;

    RecordCodeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
