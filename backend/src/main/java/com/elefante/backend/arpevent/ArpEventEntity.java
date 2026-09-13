package com.elefante.backend.arpevent;

import java.time.Instant;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(
    name = "arp_event",
    uniqueConstraints = {
        @UniqueConstraint(name = "arp_event_unique_nsr_by_employer", columnNames = { "nsr", "employer_id" })
    }
)
public class ArpEventEntity extends BaseEntity {

    @Column(name = "record_code", nullable = false, updatable = false)
    private Integer recordCode;

    @Column(name = "recorded_at", nullable = false, updatable = false)
	private Instant recordedAt;

	@Column(name = "persisted_at", nullable = false, updatable = false)
	private Instant persistedAt;

    @Column(name = "nsr", unique = true, length = 9, nullable = false, updatable = false)
	private String nsr;

    /**
     * SHA-256 from itself row's fields
     */
    @Column(name = "hash", length = 64, nullable = false, updatable = false)
	private String hash;

    /**
     * SHA-256 from previous row (NSR - 1)
     */
    @Column(name = "previous_hash", length = 64, nullable = false, updatable = false)
	private String previousHash;

	@Column(name = "employer_id", nullable = false, updatable = false)
	private Integer employerId;

    public static final String GENESIS_NSR = "000000001";

    public static final String GENESIS_HASH = "0000000000000000000000000000000000000000000000000000000000000000";
}
