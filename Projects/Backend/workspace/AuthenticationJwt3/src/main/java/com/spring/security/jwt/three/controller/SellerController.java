package com.spring.security.jwt.three.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/seller")
@Tag(name = "Seller")
public class SellerController {
	
	@GetMapping("/test")
	public String test() {
		return "Seller";
	}

}
