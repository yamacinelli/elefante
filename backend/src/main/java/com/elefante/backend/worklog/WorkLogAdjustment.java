package com.elefante.backend.worklog;

import com.elefante.backend.base.BaseEntity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import org.locationtech.jts.geom.Point;

import lombok.Data;

@Data
@Entity
@Table(name = "work_log_adjustments")
public class WorkLogAdjustmentEntity extends BaseEntity {
	
	@Column(name = "instant", nullable = false, updatable = false)
	private Instant instant;

	@Column(name = "requested_at", nullable = false, updatable = false)
	private Instant requestedAt;

	@Column(name = "audit_by")
	private Integer auditBy;

	@Column(name = "audit_at")
	private Instant auditAt;

	@Column(name = "message")
	private String message;

	@Column(name = "work_log_id, nullable = false, updatable = false)
	private Integer workLogId;

	@Column(name = "status", nullable = false)
	private String status;
}
