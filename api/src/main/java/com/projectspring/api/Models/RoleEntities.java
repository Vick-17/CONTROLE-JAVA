package com.projectspring.api.Models;

import com.projectspring.api.Generic.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RoleEntities extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
}
