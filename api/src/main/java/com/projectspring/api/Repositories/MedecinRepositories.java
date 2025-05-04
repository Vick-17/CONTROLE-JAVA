package com.projectspring.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectspring.api.Models.MedecinEntities;

public interface MedecinRepositories extends JpaRepository<MedecinEntities, Integer> {

    
}