package com.elefante.backend.arptimerecordevent;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "arp_time_record_event")
public class ArpTimeRecordEventEntity extends BaseEntity {

    @Column(name = "employee_cpf", length = 11, nullable = false, updatable = false)
    private String employeeCpf;

    @Column(name = "collector_code", length = 2, nullable = false, updatable = false)
    private String collectorCode;

    @Builder.Default
    @Column(name = "time_record_connection", nullable = false, updatable = false)
    private Integer timeRecordConnection = 0;

    @Column(name = "arp_event_id", nullable = false, updatable = false)
    private Integer arpEventId;
}
