package com.elefante.backend.worklogadjustment;

import com.elefante.backend.base.BaseWorkLogEntity;
import com.elefante.backend.base.Status;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "work_log_adjustments")
public class WorkLogAdjustmentEntity extends BaseWorkLogEntity {

	@Column(name = "requested_at", nullable = false, updatable = false)
	private Instant requestedAt;

	@Column(name = "audit_by")
	private Integer auditBy;

	@Column(name = "audit_at")
	private Instant auditAt;

	@Column(name = "message")
	private String message;

	@Column(name = "work_log_id", nullable = false, updatable = false)
	private Integer workLogId;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
}
