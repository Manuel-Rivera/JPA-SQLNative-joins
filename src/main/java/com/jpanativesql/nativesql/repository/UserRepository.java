package com.jpanativesql.nativesql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpanativesql.nativesql.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Query(value = "SELECT u.* FROM users u INNER JOIN user_roles ur ON u.id = ur.user_id WHERE ur.role = :role", nativeQuery = true)
    List<User> findByRole(@Param("role")String role);
}
