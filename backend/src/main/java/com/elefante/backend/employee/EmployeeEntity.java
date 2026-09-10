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

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "empregado")
public class EmployeeEntity extends BaseEntity {

    @Column(name = "nome", nullable = false, updatable = false)
    private String name;

    @Column(name = "cpf", unique = true, length = 11, nullable = false, updatable = false)
    private String documentNumber;

    @Builder.Default
    @Column(name = "data_admissao", nullable = false, updatable = false)
    private LocalDate hiringDate = LocalDate.now();

    @Column(name = "cargo_id", nullable = false)
    private Integer jobId;

    @Column(name = "usuario_id", nullable = false, updatable = false)
    private Integer userId;

    @Column(name = "empregador_id", nullable = false, updatable = false)
    private Integer employerId;
}
