package com.projectspring.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectspring.api.Models.ConsultationEntities;

public interface ConsultationRepositories extends JpaRepository<ConsultationEntities, Integer> {

    
}
