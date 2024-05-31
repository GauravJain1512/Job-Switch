package com.spring.security.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.auth.entity.Category;
import com.spring.security.auth.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategory(Category category);
}
