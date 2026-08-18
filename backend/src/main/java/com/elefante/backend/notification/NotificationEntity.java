package com.elefante.backend.notification;

import com.elefante.backend.base.BaseEntity;
import com.elefante.backend.base.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "notifications")
public class NotificationEntity extends BaseEntity {

	@Column(name = "title", nullable = false, updatable = false)
	private Title title;

	@Column(name = "message", nullable = false, updatable = false)
	private String message;

	@Column(name = "user_id", nullable = false, updatable = false)
	private Integer userId;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
}
