package com.elefante.backend.attendancerecord;

import com.elefante.backend.base.BaseAttendanceRecordEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "attendance_record")
public class AttendanceRecordEntity extends BaseAttendanceRecordEntity {

	@Column(name = "employee_id", nullable = false, updatable = false)
	private Integer employeeId;
}
