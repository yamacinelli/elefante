package com.elefante.backend.branch;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;

@Data
@Entity
@Table(name = "branchs")
public class BranchEntity extends BaseEntity {
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "registration_number", unique = true, lenght = 14, nullable = false, updatable = false)
	private String registrationNumber;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = Boolean.TRUE;	
}
