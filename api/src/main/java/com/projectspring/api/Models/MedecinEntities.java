package com.projectspring.api.Models;

import com.projectspring.api.Generic.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "medecin")
public class MedecinEntities extends BaseEntity {
    private int matricule;

    private String nomMED;
}
