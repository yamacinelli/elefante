package com.elefante.backend.workdetail;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.elefante.backend.base.BaseEntity;
import com.elefante.backend.util.ContractTypeEnum;
import com.elefante.backend.util.WorkModelEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "work_details")
public class WorkDetailsEntity extends BaseEntity {

    @Column(name = "work_model", nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkModelEnum workModel;

    @Column(name = "contract_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractTypeEnum contractType;

    @Column(name = "job_id", nullable = false, updatable = false)
    private Integer jobId;

    @Column(name = "schedule", columnDefinition = "JSON", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Schedule schedule;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;

    @Column(name = "branch_id", nullable = false, updatable = false)
    private Integer branchId;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;
}
