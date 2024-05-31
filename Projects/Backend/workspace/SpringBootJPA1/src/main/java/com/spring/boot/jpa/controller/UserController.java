package com.spring.boot.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.entity.Role;
import com.spring.boot.jpa.entity.User;
import com.spring.boot.jpa.repository.RoleRepository;
import com.spring.boot.jpa.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAllUser(){
		
		List<User> users = userRepository.findAll();
		for(User user : users) {
			Long roleId = user.getRoleId();
			Optional<Role> optional = roleRepository.findById(roleId);
			Role role = optional.get();
			Role role2 = user.getRole();
			System.out.print(role2);
		}
		
		return new ResponseEntity<Object>(users, HttpStatus.OK);
		
	}

}
