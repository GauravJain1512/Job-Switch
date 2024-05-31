package com.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.jpa.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
