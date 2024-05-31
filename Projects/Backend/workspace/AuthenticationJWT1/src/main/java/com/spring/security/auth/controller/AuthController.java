package com.spring.security.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.auth.model.JwtRequest;
import com.spring.security.auth.service.CustomUserDetailsService;
import com.spring.security.auth.service.JwtService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@PostMapping("/auth")
	public ResponseEntity<Object> login(@RequestBody JwtRequest user){
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			UserDetails userDetails = userDetailsService.loadUserByUsername(authenticate.getName());
			String token = jwtService.generateToken(userDetails);
			return new ResponseEntity<Object>(token, HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<Object>("Bad Credentails", HttpStatus.BAD_REQUEST);
		}
	}

}
