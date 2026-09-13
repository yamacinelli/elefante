package com.elefante.backend.arpemployeeevent;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "arp_employee_event")
public class ArpEmployeeEventEntity extends BaseEntity {

    @Column(name = "employee_cpf", length = 11, nullable = false, updatable = false)
    private String employeeCpf;

    @Column(name = "employee_name", length = 52, nullable = false, updatable = false)
    private String employeeName;

    @Column(name = "job_name", length = 52, nullable = false, updatable = false)
    private String jobName;

    @Column(name = "operation", nullable = false, updatable = false)
    private String operation;

    @Column(name = "cpf_responsible_data_manipulation", length = 11, nullable = false, updatable = false)
    private String cpfResponsibleDataManipulation;

    @Column(name = "arp_event_id", nullable = false, updatable = false)
    private Integer arpEventId;
}
