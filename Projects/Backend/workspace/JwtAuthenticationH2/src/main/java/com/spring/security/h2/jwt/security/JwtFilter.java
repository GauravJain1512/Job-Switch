package com.spring.security.h2.jwt.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.security.h2.jwt.exception.JwtException;
import com.spring.security.h2.jwt.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");
		if(StringUtils.hasText(header) && header.startsWith("Bearer ")) {
			String token = header.substring(7);
			try {
				String username = jwtService.extractUsername(token);
				if(StringUtils.hasText(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					if(jwtService.validateToken(token, userDetails) && isUserRoleAutorized(userDetails, token)) {
						UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
						authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					}else {
						throw new JwtException("Invalid token");
					}
				}else {
					throw new JwtException("Invalid username");
				}
			}catch (IllegalArgumentException e) {
				throw new JwtException("JWT claims string is empty");
			}catch (ExpiredJwtException e) {
				throw new JwtException("Expired JWT token");
			}catch (SignatureException e) {
				throw new JwtException("Invalid JWT signature");
			}catch (MalformedJwtException e) {
				throw new JwtException("Invalid JWT token");
			}catch (UnsupportedJwtException e) {
				throw new JwtException("Unsupported JWT token");
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

	private boolean isUserRoleAutorized(UserDetails userDetails, String token) {
		List<String> roles = jwtService.extractClaim(token, claims->claims.get("roles", List.class));
		
		String role = userDetails.getAuthorities().stream().map(GrantedAuthority :: getAuthority).findFirst().orElse(null);
		
		return roles.contains(role);
	}
	
	

}
