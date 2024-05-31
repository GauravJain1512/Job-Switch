package com.spring.security.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Optional<Role> findByRolename(String rolename);
}
