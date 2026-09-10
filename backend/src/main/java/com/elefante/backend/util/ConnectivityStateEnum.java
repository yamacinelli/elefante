package com.elefante.backend.util;

public enum ConnectivityStateEnum {
    ONLINE(0),
    OFFLINE(1);

    private Integer value;

    ConnectivityStateEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
