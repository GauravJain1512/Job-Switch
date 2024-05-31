package com.spring.security.jwt.two.repository;

import com.spring.security.jwt.two.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
