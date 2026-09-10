package com.elefante.backend.employer;

import com.elefante.backend.base.BaseEntity;
import com.elefante.backend.util.DocumentTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "empregador")
public class EmployerEntity extends BaseEntity {

    @Column(name = "razao_social", nullable = false)
    private String legalName;

    @Column(name = "tipo_documento", length = 4, nullable = false)
    private DocumentTypeEnum documentType;

    @Column(name = "numero_documento", unique = true, length = 14, nullable = false, updatable = false)
    private String documentNumber;

    @Column(name = "cnae", length = 7, nullable = false, updatable = false)
    private String cnae;
}
