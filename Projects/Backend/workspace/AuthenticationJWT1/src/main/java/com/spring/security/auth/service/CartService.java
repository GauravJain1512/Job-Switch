package com.spring.security.auth.service;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.security.auth.entity.Cart;
import com.spring.security.auth.entity.User;
import com.spring.security.auth.exception.ResourceNotFoundException;
import com.spring.security.auth.repository.CartRepository;
import com.spring.security.auth.repository.UserRepository;

@Service
public class CartService {

	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public ResponseEntity<Object> getCartByUserId(Long userId, Principal principal) {
	
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
		if(principal.getName().equals(user.getEmail())) {
			
		
		Optional<Cart> optionalCart = cartRepository.findByUser(user);
		
		if(optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			return new ResponseEntity<Object>(cart, HttpStatus.OK);
		}{
			return new ResponseEntity<Object>("Please create new Cart", HttpStatus.NO_CONTENT);
		}
		}else {
			return new ResponseEntity<Object>("Access Denies", HttpStatus.FORBIDDEN);
		}
	}
	
	public ResponseEntity<Object> createCart(Long userId, Principal principal){
		
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		if(principal.getName().equals(user.getEmail())) {
			Cart cart = new Cart();
			cart.setUser(user);
			Cart savedCart = cartRepository.save(cart);
			return new ResponseEntity<Object>(savedCart, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
		}
	}
}
