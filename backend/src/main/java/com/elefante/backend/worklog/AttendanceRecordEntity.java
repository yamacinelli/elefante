package com.elefante.backend.worklog;

import com.elefante.backend.base.BaseAttendanceRecordEntity;
import com.elefante.backend.util.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

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
@Table(name = "registro_ponto")
public class AttendanceRecordEntity extends BaseAttendanceRecordEntity {

	@Column(name = "numero_sequencial_registro", unique = true, length = 9, nullable = false, updatable = false)
	private String sequentialRegistrationNumber;

	@Column(name = "codigo_hash", length = 64, nullable = false, updatable = false)
	private String hashCode;

	@Column(name = "empregado_id", nullable = false, updatable = false)
	private Integer employeeId;

	@Builder.Default
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status = StatusEnum.OK;
}
