package com.elefante.backend.jobdetail;

public enum JobModelEnum {

    IN_LOCO("PRESENCIAL"),
    HYBRID("HIBRIDO"),
    REMOTE("REMOTO");

    private String value;

    JobModelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
