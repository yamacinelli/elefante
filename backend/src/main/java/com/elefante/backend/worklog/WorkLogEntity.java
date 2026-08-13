package com.elefante.backend.worklog;

import com.elefante.backend.base.BaseEntity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Column;

import org.locationtech.jts.geom.Point;

import lombok.Data;

@Data
@Entity
@Table(
	name = "work_logs",
	uniqueConstraints = {
		@UniqueConstraint(name = "unique_sequential_registration_number_by_branch", columnNames = { "sequential_registration_number", "branch_id" }	
	}
)
public class WorkLogEntity extends BaseEntity {

	@Column(name = "sequential_registration_number", lenght = 9, nullable = false, updatable = false)
	private Integer sequentialRegistrationNumber;

	@Column(name = "instant", nullable = false, updatable = false)
	private Instant instant;

	@Column(name = "fiscal_date", lenght = 8, nullable = false, updatable = false)
	private String fiscalDate;

	@Column(name = "fiscal_time", lenght = 4, nullable = false, updatable = false)
	private String fiscalTime;

	@Column(name = "coordinates", columnDefinition = "POINT SRID 4326", nullable = false, updatable = false)
	private Point coordinates;

	@Column(name = "hash", lenght = 64, nullable = false, updatable = false)
	private String hash;

	@Column(name = "user_id", nullable = false, updatable = false)
	private Integer userId;

	@Column(name = "branch_id", nullable = false, updatable = false)
	private Integer branchId;

        @Column(name = "status", nullable = false)
        private String status;
}
