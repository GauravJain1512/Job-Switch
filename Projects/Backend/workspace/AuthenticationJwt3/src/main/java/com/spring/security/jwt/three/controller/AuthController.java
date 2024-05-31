package com.spring.security.jwt.three.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.jwt.three.model.JwtRequest;
import com.spring.security.jwt.three.security.JwtService;
import com.spring.security.jwt.three.security.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final JwtService jwtService;
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	private final AuthenticationManager authenticationManager;
	
	@PostMapping("/auth")
	public ResponseEntity<Object> loginApi(@RequestBody JwtRequest request){
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authenticate.getName());
			String token = jwtService.generateToken(userDetails);
			return new ResponseEntity<Object>(token, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<Object>("Bad Credentials", HttpStatus.BAD_REQUEST);
		}
	}

}
