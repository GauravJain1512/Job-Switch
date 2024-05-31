package com.spring.security.jwt.three.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.jwt.three.entity.User;
import com.spring.security.jwt.three.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username: "+username));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapUserAuthority(user));
	}

	private Collection<? extends GrantedAuthority> mapUserAuthority(User user) {
		
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+user.getRole().getRoleName());
		return java.util.Collections.singletonList(grantedAuthority);
	}

}
