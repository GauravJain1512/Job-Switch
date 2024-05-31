package com.spring.security.auth.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.spring.security.auth.entity.Role;
import com.spring.security.auth.entity.User;
import com.spring.security.auth.exception.ResourceNotFoundException;
import com.spring.security.auth.model.UserModel;
import com.spring.security.auth.repository.RoleRepository;
import com.spring.security.auth.repository.UserRepository;

@Service
public class PublicService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public UserModel saveUserModel(UserModel userModel, String rolename) {
		
		User user = mapper.map(userModel, User.class);
		Optional<Role> optionalRole = roleRepository.findByRolename(rolename);
		Role role = null;
		if(optionalRole.isPresent()) {
			role = optionalRole.get();
		}else {
			role = new Role();
			role.setRolename(rolename);
		}
		user.setRoles(Collections.singleton(role));
		User user2 = userRepository.save(user);
		return mapper.map(user2, UserModel.class);
	}
	
	@PostAuthorize("returnObject.email == authentication.principal.username")
	public UserModel findUserById(Long id) {
		
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Id",id));
		
		return mapper.map(user, UserModel.class);
	}
	
	@PreAuthorize("#email == authentication.principal.username")
	public UserModel findUserByEmail(String email) {
		
		User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User","Email",email));
		
		return mapper.map(user, UserModel.class);
	}

}
