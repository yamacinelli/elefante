package com.elefante.backend.datasourcefile;

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
@Table(name = "data_source_file")
public class DataSourceFileEntity extends BaseEntity {

    @Column(name = "nsr", unique = true, length = 9, nullable = false, updatable = false)
	private String nsr;

    @Column(name = "data_type", nullable = false, updatable = false)
    private String dataType;

    @Column(name = "trademark", nullable = false, updatable = false)
    private String trademark;

    /**
     * SHA-256 from itself row's fields
     */
    @Column(name = "hash", length = 64, nullable = false, updatable = false)
	private String hash;

    /**
     * SHA-256 from previous row (NSR - 1)
     */
    @Column(name = "previous_hash", length = 64, updatable = false)
	private String previousHash;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
}
