package com.spring.security.h2.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.h2.jwt.entity.Role;

public interface RoleRepositoy extends JpaRepository<Role, Long> {

}
