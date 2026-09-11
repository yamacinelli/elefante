package com.elefante.backend.recordstorage;

import java.time.Instant;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "armazenamento_registro_ponto")
public class RecordStorageEntity extends BaseEntity {

    @Column(name = "numero_sequencial_registro", unique = true, length = 9, nullable = false, updatable = false)
	private String sequentialRegistrationNumber;

    @Column(name = "tipo_registro", nullable = false, updatable = false)
    private String dataRecordType;

    @Column(name = "registro_marca", nullable = false, updatable = false)
    private String trademark;

    /**
     * SHA-256 from itself row's fields
     */
    @Column(name = "codigo_hash", length = 64, nullable = false, updatable = false)
	private String hashCode;

    /**
     * SHA-256 from previous row (sequentialRegistrationNumber - 1)
     */
    @Column(name = "codigo_hash_anterior", length = 64, updatable = false)
	private String previousHashCode;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private Instant createdAt;
}
