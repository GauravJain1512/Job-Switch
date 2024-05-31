package com.spring.security.auth.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.auth.entity.Role;
import com.spring.security.auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
	List<User> findByRoles(Set<Role> roles);

}
