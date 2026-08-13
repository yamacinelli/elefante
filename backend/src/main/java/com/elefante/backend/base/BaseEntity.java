package com.elefante.backend.base;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import lombok.Data;

/**
 * Simple JavaBean domain object with an id property. Used as a base class for objects
 * needing this property.
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Boolean isNew() {
		return this.id == null;
	}
}
