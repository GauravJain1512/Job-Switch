package com.spring.security.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.auth.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
