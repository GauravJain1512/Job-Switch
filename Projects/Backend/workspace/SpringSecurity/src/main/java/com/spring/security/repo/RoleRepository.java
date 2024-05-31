package com.spring.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
