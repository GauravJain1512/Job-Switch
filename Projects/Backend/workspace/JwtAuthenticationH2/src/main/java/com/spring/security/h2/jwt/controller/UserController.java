package com.spring.security.h2.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.h2.jwt.entity.Role;
import com.spring.security.h2.jwt.entity.Users;
import com.spring.security.h2.jwt.service.UserService;

@RestController
public class UserController {
	
	

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsers(){
		 List<Users> users = userService.getUsers();
		 if(users.isEmpty()) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }else {
			 return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
		 }
	}
	
	@PostMapping("/users")
	public ResponseEntity<Users> saveUser(@RequestBody Users users){
		Users saveUser = userService.saveUser(users);
		return new ResponseEntity<Users>(saveUser, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/users/{userId}")
	public ResponseEntity<Object> addRole(@PathVariable Long userId, @RequestBody Role role){
		return userService.addRoleToUser(userId, role);
	}
			

}
