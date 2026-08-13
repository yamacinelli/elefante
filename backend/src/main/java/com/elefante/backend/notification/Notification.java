package com.elefante.backend.notification;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;

@Data
@Entity
@Table(name = "notifications")
public class NotificationEntity extends BaseEntity {
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "user_id", nullable = false, updatable = false)
	private Integer userId;

	@Column(name = "status", nullable = false)
	private String status;
}
