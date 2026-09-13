package com.elefante.backend.arpsensitiveevent;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "arp_sensitive_event")
public class ArpSensitiveEventEntity extends BaseEntity {

    @Column(name = "event_code", length = 2, nullable = false, updatable = false)
    private String eventCode;

    @Column(name = "arp_event_id", nullable = false, updatable = false)
    private Integer arpEventId;
}
