package com.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
