package com.elefante.backend.attendancerecord;

import java.time.Instant;

import org.locationtech.jts.geom.Point;

import com.elefante.backend.base.BaseEntity;
import com.elefante.backend.util.CollectorIdentifierEnum;

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
@Table(name = "attendance_record")
public class AttendanceRecordEntity extends BaseEntity {

	@Column(name = "record_instant", nullable = false, updatable = false)
	private Instant recordInstant;

	@Column(name = "persist_instant", nullable = false, updatable = false)
	private Instant persistInstant;

	@Builder.Default
	@Column(name = "collector_identifier", length = 2, nullable = false, updatable = false)
	@Enumerated(EnumType.ORDINAL)
	private CollectorIdentifierEnum collectorIdentifier = CollectorIdentifierEnum.BROWSER;

	@Column(name = "coordinate", columnDefinition = "POINT", nullable = false, updatable = false)
	private Point coordinate;

	@Column(name = "employee_id", nullable = false, updatable = false)
	private Integer employeeId;
}
