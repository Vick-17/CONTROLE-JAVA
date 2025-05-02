package com.projectspring.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectspring.api.Models.UserEntities;

public interface UserRepositories extends JpaRepository<UserEntities, Long> {
    
    UserEntities findByUsername(String username);
}
