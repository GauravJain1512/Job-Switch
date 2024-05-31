package com.spring.security.auth.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import com.spring.security.auth.entity.Role;
import com.spring.security.auth.entity.User;
import com.spring.security.auth.model.UserModel;
import com.spring.security.auth.repository.RoleRepository;
import com.spring.security.auth.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	public List<UserModel> getUsersByRoleName(String rolename){
		
		Optional<Role> optionalRole = roleRepository.findByRolename(rolename);
		if(optionalRole.isPresent()) {
			Role role = optionalRole.get();
			List<User> users = userRepository.findByRoles(Collections.singleton(role));
			return users.stream().map(u-> mapper.map(u, UserModel.class) )
					.collect(Collectors.toList());
		}
		
		return null;
		
	}
	
	@PostFilter("filterObject.username != 'Test'")
	public List<UserModel> getAllUsers(){
		List<User> users = userRepository.findAll();
		return users.stream().map(u-> mapper.map(u, UserModel.class))
		.collect(Collectors.toList());
		
	}

}
