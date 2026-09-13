package com.elefante.backend.timerecord;

import java.time.Instant;

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
@Table(name = "time_record")
public class TimeRecordEntity extends BaseEntity {

    @Column(name = "recorded_at", nullable = false, updatable = false)
	private Instant recordedAt;

    @Column(name = "employee_id", nullable = false, updatable = false)
    private Integer employeeId;
}
