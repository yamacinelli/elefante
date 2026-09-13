package com.elefante.backend.arptimerecordevent;

public enum CollectorIdentifierEnum {

    MOBILE_APP("01"),
    BROWSER("02"),
    DESKTOP_APP("03");

    private String value;

    CollectorIdentifierEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
