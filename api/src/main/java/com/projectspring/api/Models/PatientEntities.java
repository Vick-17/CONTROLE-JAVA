package com.projectspring.api.Models;

import com.projectspring.api.Generic.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "patient")
public class PatientEntities extends BaseEntity {
    private long NSS;
    private String nomPAT;
}
