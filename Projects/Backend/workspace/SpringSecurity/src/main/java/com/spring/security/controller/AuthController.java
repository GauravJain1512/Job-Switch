package com.spring.security.controller;

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

import com.spring.security.config.CustomUserDeatilsService;
import com.spring.security.config.JwtTokenHelper;
import com.spring.security.entity.User;



@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDeatilsService customUserDeatilsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@PostMapping("/auth")
	public ResponseEntity<String> login(@RequestBody User user){
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
			Authentication authenticate = authenticationManager.authenticate(authenticationToken);
			UserDetails userDetails = customUserDeatilsService.loadUserByUsername(authenticate.getName());
			String token = jwtTokenHelper.generateToken(userDetails);
			return new ResponseEntity<String>(token,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Bad Credentials",HttpStatus.BAD_REQUEST);
		}
	}

}
