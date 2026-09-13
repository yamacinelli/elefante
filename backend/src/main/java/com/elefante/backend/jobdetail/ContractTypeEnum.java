package com.elefante.backend.jobdetail;

public enum ContractTypeEnum {
    FREELANCE("HORISTA"),
    TEMPORARY("TEMPORARIO"),
    INDEFINITE("INDEFINIDO"),
    INTERNSHIP("ESTAGIARIO"),
    /**
     * A contract where the employer does not guarantee a
     * minimum number of hours and only pays for the hours
     * actually worked.
     */
    ZERO_HOUR("INTERMITENTE");

    private String value;

    ContractTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
