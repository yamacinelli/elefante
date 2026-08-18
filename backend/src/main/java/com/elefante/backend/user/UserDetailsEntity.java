package com.elefante.backend.user;

import com.elefante.backend.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "user_details")
public class UserDetailsEntity extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(name = "last_name", nullable = false, updatable = false)
    private String lastName;

    @Column(name = "identification_number", unique = true, length = 11, nullable = false, updatable = false)
    private Integer identificationNumber;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Integer userId;
}
