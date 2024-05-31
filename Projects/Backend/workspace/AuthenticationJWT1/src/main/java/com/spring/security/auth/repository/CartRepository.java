package com.spring.security.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.auth.entity.Cart;
import com.spring.security.auth.entity.Product;
import com.spring.security.auth.entity.User;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Optional<Cart> findByUser(User user);
	
	Optional<Cart> findByCartProductsProduct(Product product);
}
