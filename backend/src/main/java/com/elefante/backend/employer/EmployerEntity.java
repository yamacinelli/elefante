package com.elefante.backend.employer;

import com.elefante.backend.base.BaseEntity;
import com.elefante.backend.util.DocumentTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "employer")
public class EmployerEntity extends BaseEntity {

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(name = "document_type", length = 4, nullable = false)
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum documentType;

    @Column(name = "document_number", unique = true, length = 14, nullable = false, updatable = false)
    private String documentNumber;

    @Column(name = "cnae", length = 7, nullable = false, updatable = false)
    private String cnae;

    @Column(name = "address", nullable = false)
    private String address;
}
