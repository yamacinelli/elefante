package com.elefante.backend.branch;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "branchs")
public class BranchEntity extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "registration_number", unique = true, length = 14, nullable = false, updatable = false)
	private String registrationNumber;

	@Column(name = "is_enabled", nullable = false)
	private Boolean isEnabled = Boolean.TRUE;
}
