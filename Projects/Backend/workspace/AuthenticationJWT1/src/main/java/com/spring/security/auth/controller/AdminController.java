package com.spring.security.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.auth.model.UserModel;
import com.spring.security.auth.service.AdminService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/test")
	public String test() {
		return "Admin";
	}
	
	@GetMapping("/users/{rolename}")
	public ResponseEntity<Object> getUserByRoleName(@PathVariable String rolename){
		
		List<UserModel> users = adminService.getUsersByRoleName(rolename);
		if(null != users && !users.isEmpty()) {
			return new ResponseEntity<Object>(users, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Invalid Rolename", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAllUsers(){
		 List<UserModel> users = adminService.getAllUsers();
		 return new ResponseEntity<Object>(users, HttpStatus.OK);
	}

}
