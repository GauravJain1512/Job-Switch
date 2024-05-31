package com.spring.security.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.auth.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<Object> findByUserId(@PathVariable Long userId, Principal principal){
	
		return cartService.getCartByUserId(userId, principal);
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<Object> createNewCart(@PathVariable Long userId, Principal principal){
		
		return cartService.createCart(userId, principal);
	}
	
	

}
