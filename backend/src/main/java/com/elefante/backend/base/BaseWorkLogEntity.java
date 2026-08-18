package com.elefante.backend.base;

import java.time.Instant;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@MappedSuperclass
public class BaseWorkLogEntity extends BaseEntity {

    @Column(name = "instant", nullable = false, updatable = false)
	private Instant instant;

	@Column(name = "coordinates", columnDefinition = "POINT", nullable = false, updatable = false)
	private Point coordinates;
}
