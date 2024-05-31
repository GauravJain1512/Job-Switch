package com.spring.security.jwt.two.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.jwt.two.model.JwtRequest;
import com.spring.security.jwt.two.model.JwtResponse;
import com.spring.security.jwt.two.model.JwtResponse.JwtResponseBuilder;
import com.spring.security.jwt.two.security.UserDetailsServiceImpl;
import com.spring.security.jwt.two.serivice.JwtService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	
	@PostMapping
	public ResponseEntity<Object> login(@RequestBody JwtRequest jwtRequest){
		
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authenticate.getName());
			String token = jwtService.generateToken(userDetails);
			JwtResponse jwtResponse = JwtResponse.builder().token(token).status(HttpStatus.OK.toString()).build();
			return new ResponseEntity<Object>(jwtResponse, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}


}
