package com.spring.security.jwt.three.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/public")
@Tag(name = "Public")
public class PublicController {
	
	@Operation(summary = "public api", description = "test of public api", responses = @ApiResponse(responseCode = "200", description = "Success"))
	@GetMapping
	public String test() {
		return "public";
	}

}
