package com.elefante.backend.base;

import java.time.Instant;

import org.locationtech.jts.geom.Point;

import com.elefante.backend.util.CollectorIdentifierEnum;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public class BaseAttendanceRecordEntity extends BaseEntity {

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
}
