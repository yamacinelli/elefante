package com.elefante.backend.employee;

import java.time.LocalDate;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity {

    @Column(name = "name", length = 52, nullable = false)
    private String name;

    @Column(name = "cpf", unique = true, length = 11, nullable = false)
    private String cpf;

    @Builder.Default
    @Column(name = "hiring_date", nullable = false, updatable = false)
    private LocalDate hiringDate = LocalDate.now();

    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;

    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Column(name = "employer_id", nullable = false, updatable = false)
    private Integer employerId;
}
