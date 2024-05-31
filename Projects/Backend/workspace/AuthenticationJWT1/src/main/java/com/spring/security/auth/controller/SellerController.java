package com.spring.security.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/seller")
@SecurityRequirement(name = "bearerAuth")
public class SellerController {
	
	@GetMapping("/test")
	public String test() {
		return "seller";
	}

}
