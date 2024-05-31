package com.spring.security.h2.jwt.controller;

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

import com.spring.security.h2.jwt.model.JwtRequest;
import com.spring.security.h2.jwt.model.JwtResponse;
import com.spring.security.h2.jwt.security.CustomUserDetailsService;
import com.spring.security.h2.jwt.service.JwtService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/auth")
	public ResponseEntity<Object> authenticate(@RequestBody JwtRequest jwtRequest){
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			UserDetails userDetails = userDetailsService.loadUserByUsername(authenticate.getName());
			String token = jwtService.generateToken(userDetails);
			JwtResponse jwtResponse = new JwtResponse();
			jwtResponse.setToken(token);
			jwtResponse.setStatus(HttpStatus.OK.toString());
			return new ResponseEntity<Object>(jwtResponse, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>("Bad Credentials",HttpStatus.BAD_REQUEST);
		}
	}

}
