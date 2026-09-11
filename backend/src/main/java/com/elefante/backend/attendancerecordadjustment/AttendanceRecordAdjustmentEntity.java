package com.elefante.backend.attendancerecordadjustment;

import com.elefante.backend.base.BaseAttendanceRecordEntity;
import com.elefante.backend.util.RecordStatusEnum;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "attendance_record_adjustment")
public class AttendanceRecordAdjustmentEntity extends BaseAttendanceRecordEntity {

	@Column(name = "requested_at", nullable = false, updatable = false)
	private Instant requestedAt;

	@Column(name = "audit_by")
	private Integer auditBy;

	@Column(name = "audit_at")
	private Instant auditAt;

	@Column(name = "message")
	private String message;

	@Column(name = "attendance_record_id", nullable = false, updatable = false)
	private Integer attendanceRecordId;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private RecordStatusEnum status;
}
