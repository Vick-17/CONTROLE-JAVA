package com.projectspring.api.Models;

import com.projectspring.api.Generic.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "medicament")
@Getter
@Setter
@Accessors(chain = true)
public class MedicamentEntities extends BaseEntity {
    private int code;
    private String libelle;
}
