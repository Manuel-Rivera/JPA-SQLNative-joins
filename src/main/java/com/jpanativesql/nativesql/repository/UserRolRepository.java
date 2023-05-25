package com.jpanativesql.nativesql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpanativesql.nativesql.entities.UserRole;
import com.jpanativesql.nativesql.entities.DTOS.IUserRolDTO;

public interface UserRolRepository extends JpaRepository<UserRole,Long> {
    @Query(value = "select u.username,us.role from users u JOIN user_roles us where u.username='user1'", nativeQuery = true)
    List<Object[]> getUserRolList();

    @Query(value = "select u.username,us.role from users u JOIN user_roles us where u.username='user1'", nativeQuery = true)
    List<IUserRolDTO> getUserRolListInterface();
}
