package com.elefante.backend.job;

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
@Table(name = "cargo")
public class JobEntity extends BaseEntity {

    @Column(name = "nome", nullable = false)
    private String name;

    @Builder.Default
    @Column(name = "ativo", nullable = false)
    private Boolean isEnabled = Boolean.TRUE;
}
