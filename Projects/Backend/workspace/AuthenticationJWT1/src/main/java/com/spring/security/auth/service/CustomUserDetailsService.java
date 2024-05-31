package com.spring.security.auth.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.auth.entity.User;
import com.spring.security.auth.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username: "+username));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthority(user));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthority(User user) {
		
		List<SimpleGrantedAuthority> authority = user.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRolename())).collect(Collectors.toList());
		return authority;
	}

}
