package com.spring.security.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.auth.model.UserModel;
import com.spring.security.auth.service.PublicService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/public")
public class PublicController {
	
	@Autowired
	private PublicService publicService;
	
	@PostMapping("/users/{rolename}")
	public ResponseEntity<Object> register(@Valid @RequestBody UserModel userModel,@PathVariable String rolename){
		
		UserModel saveUserModel = publicService.saveUserModel(userModel,rolename);
		if(null != saveUserModel) {
			return new ResponseEntity<Object>(saveUserModel, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Bad Request", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<Object> getCurrentLoginUser(@PathVariable Long userId){
		
		UserModel userModel = publicService.findUserById(userId);
		
		return new ResponseEntity<Object>(userModel, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getCurrentLoginUserByEmail(@RequestParam String email){
		
		UserModel userModel = publicService.findUserByEmail(email);
		
		return new ResponseEntity<Object>(userModel, HttpStatus.OK);
		
		
	}

}
