package com.spring.security.h2.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	
	@GetMapping("/test")
	public String getAdmin() {
		return "Admin user";
	}

}
