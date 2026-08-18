package com.elefante.backend.workdetail;

public enum ContractType {
    FREELANCE,
    TEMPORARY,
    INDEFINITE,
    INTERNSHIP,
    /**
     * A contract where the employer does not guarantee a
     * minimum number of hours and only pays for the hours
     * actually worked.
     */
    ZERO_HOUR
}
