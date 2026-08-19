package com.elefante.backend.worklog;

import com.elefante.backend.base.BaseWorkLogEntity;
import com.elefante.backend.util.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(
	name = "work_logs",
	uniqueConstraints = {
		@UniqueConstraint(name = "unique_sequential_registration_number_by_branch", columnNames = { "sequential_registration_number", "branch_id" })
	}
)
public class WorkLogEntity extends BaseWorkLogEntity {

	@Column(name = "sequential_registration_number", length = 9, nullable = false, updatable = false)
	private Integer sequentialRegistrationNumber;

	@Column(name = "fiscal_date", length = 8, nullable = false, updatable = false)
	private String fiscalDate;

	@Column(name = "fiscal_time", length = 4, nullable = false, updatable = false)
	private String fiscalTime;

	@Column(name = "hash", length = 64, nullable = false, updatable = false)
	private String hash;

	@Column(name = "user_id", nullable = false, updatable = false)
	private Integer userId;

	@Column(name = "branch_id", nullable = false, updatable = false)
	private Integer branchId;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
}
