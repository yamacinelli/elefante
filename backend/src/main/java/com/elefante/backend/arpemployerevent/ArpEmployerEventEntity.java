package com.elefante.backend.arpemployerevent;

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
@Table(name = "arp_employer_event")
public class ArpEmployerEventEntity extends BaseEntity {

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(name = "document_type", length = 4, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private DocumentTypeEnum documentType;

    @Column(name = "document_number", unique = true, length = 14, nullable = false, updatable = false)
    private String documentNumber;

    @Column(name = "cnae", length = 7, nullable = false, updatable = false)
    private String cnae;

    @Column(name = "caep_cno", length = 20, updatable = false)
    private String caepCno;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "operation", nullable = false, updatable = false)
    private String operation;

    @Column(name = "cpf_responsible_data_manipulation", length = 11, nullable = false, updatable = false)
    private String cpfResponsibleDataManipulation;

    @Column(name = "arp_event_id", nullable = false, updatable = false)
    private Integer arpEventId;
}
