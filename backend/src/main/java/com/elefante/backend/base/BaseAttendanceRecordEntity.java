package com.elefante.backend.base;

import java.time.Instant;

import org.locationtech.jts.geom.Point;

import com.elefante.backend.util.CollectorIdentifierEnum;
import com.elefante.backend.util.ConnectivityStateEnum;
import com.elefante.backend.util.RecordTypeEnum;

import jakarta.persistence.Column;
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

    @Column(name = "data_hora_registro", nullable = false, updatable = false)
	private Instant recordInstant;

	@Builder.Default
	@Column(name = "data_hora_gravacao", nullable = false, updatable = false)
	private Instant persistInstant = Instant.now();

	@Column(name = "tipo_registro", nullable = false, updatable = false)
	private RecordTypeEnum recordType;

	@Column(name = "estado_conexao", nullable = false, updatable = false)
	private ConnectivityStateEnum connectivityState;

	@Column(name = "identificador_coletor", nullable = false, updatable = false)
	private CollectorIdentifierEnum collectorIdentifier;

	@Column(name = "coordenada", columnDefinition = "POINT", nullable = false, updatable = false)
	private Point coordinate;
}
