package com.spring.security.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.auth.entity.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

}
