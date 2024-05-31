package com.spring.security.config;

import java.io.IOException;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
//		if(authException.getMessage().contains("Full authentication is required to access this resource")) {
//			response.sendError(HttpServletResponse.SC_FORBIDDEN,"Access Denied!!");
//		}
		response.sendError(HttpServletResponse.SC_FORBIDDEN,"Access Denied!!");

	}

}