package com.jpanativesql.nativesql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpanativesql.nativesql.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
    @Query(value = "SELECT u.* FROM users u INNER JOIN user_roles ur ON u.id = ur.user_id WHERE ur.role = :role", nativeQuery = true)
    List<User> findByRole(@Param("role")String role);
}
