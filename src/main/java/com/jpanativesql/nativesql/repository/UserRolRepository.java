package com.jpanativesql.nativesql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpanativesql.nativesql.entities.UserRole;

public interface UserRolRepository extends JpaRepository<UserRole,Long> {
    
}
