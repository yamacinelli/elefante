package com.elefante.backend.util;

public enum RecordTypeEnum {
    START("ENTRADA"),
    INTERVAL_START("INTERVALO_INICIO"),
    INTERVAL_END("INTERVALO_FIM"),
    END("SAIDA");

    private String value;

    RecordTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
