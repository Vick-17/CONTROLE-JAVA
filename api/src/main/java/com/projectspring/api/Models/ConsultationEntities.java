package com.projectspring.api.Models;

import java.util.Date;

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
@Table(name = "consultation")
public class ConsultationEntities extends BaseEntity {
    private int numero;

    private Date date;
}
