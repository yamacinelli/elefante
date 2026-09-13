package com.elefante.backend.arptimerecordevent;

public enum CollectorCodeEnum {

    MOBILE_APP("01"),
    BROWSER("02"),
    DESKTOP_APP("03");

    private String value;

    CollectorCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
