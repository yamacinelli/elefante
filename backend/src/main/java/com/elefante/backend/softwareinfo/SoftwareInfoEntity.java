package com.elefante.backend.softwareinfo;

import com.elefante.backend.base.BaseEntity;
import com.elefante.backend.util.DocumentTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "software_info")
public class SoftwareInfoEntity extends BaseEntity {

    @Builder.Default
    @Column(name = "rep_type", nullable = false, updatable = false)
    private String repType = "REP-P";

    @Column(name = "trademark", nullable = false, updatable = false)
    private String trademark;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "document_type", length = 4, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum documentType;

    @Column(name = "document_number", unique = true, length = 14, nullable = false, updatable = false)
    private String documentNumber;

    @Column(name = "developer_legal_name", nullable = false, updatable = false)
    private String developerLegalName;

    @Column(name = "developer_email", nullable = false, updatable = false)
    private String developerEmail;
}
