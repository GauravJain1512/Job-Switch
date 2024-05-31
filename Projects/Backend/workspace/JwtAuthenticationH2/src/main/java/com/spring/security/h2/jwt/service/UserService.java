package com.spring.security.h2.jwt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.security.h2.jwt.entity.Role;
import com.spring.security.h2.jwt.entity.Users;
import com.spring.security.h2.jwt.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getUsers(){
		return userRepository.findAll();
	}

	public Users saveUser(Users user) {
		return userRepository.save(user);
	}
	
	public ResponseEntity<Object>  addRoleToUser(Long userId, Role role) {
		
		Optional<Users> optional = userRepository.findById(userId);
		if(optional.isEmpty()) {
			return new ResponseEntity<Object>("Invalid User",HttpStatus.BAD_REQUEST);
		}else {
			Users users = optional.get();
			Set<Role> roles = users.getRoles();
			roles.add(role);
			users.setRoles(roles);
			userRepository.save(users);
			return new ResponseEntity<Object>("Role has been assigned successfully", HttpStatus.OK);
		}
	}
}
