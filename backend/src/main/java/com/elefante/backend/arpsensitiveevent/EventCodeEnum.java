package com.elefante.backend.arpsensitiveevent;

public enum EventCodeEnum {

    ENERGY_RETURN("02"),
    SERVICE_AVAILIBITY("07"),
    SERVICE_UNAVAILIBITY("08");

    private String value;

    EventCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
