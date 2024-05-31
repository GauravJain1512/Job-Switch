package com.spring.security.jwt.two.repository;

import com.spring.security.jwt.two.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByEmail(String email);
}
