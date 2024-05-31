package com.spring.security.auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.auth.service.ConsumerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/consumer")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Operation(
			summary = "Test Swagger",
			description = "This is cool",
			responses = {
					@ApiResponse(
							responseCode = "200", description = "Suceess"
							),
					@ApiResponse(
							responseCode = "401", description = "Invalid token"
							)
			}
			)
	@GetMapping("/test")
	public String test() {
		return "consumer";
	}
	
	@PostMapping("/addProduct/{cartId}/{productId}")
	public ResponseEntity<Object> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, Principal principal ){
		
		return consumerService.addProductToCart(cartId, productId, principal);
	}

}
