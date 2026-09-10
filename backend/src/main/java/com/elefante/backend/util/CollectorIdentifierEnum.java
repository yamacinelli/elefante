package com.elefante.backend.util;

public enum CollectorIdentifierEnum {
    MOBILE_APP("01"),
    BROWSER("02"),
    DESKTOP_APP("03"),
    ELETRONIC_DEVICE("04"),
    ANOTHER_DEVICE("05");

    private String value;

    CollectorIdentifierEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
