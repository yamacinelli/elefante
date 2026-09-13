package com.elefante.backend.arpemployerevent;

public enum OperationEnum {

    INSERT("I"),
    UPDATE("A"),
    DELETE("E");

    private String value;

    OperationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
