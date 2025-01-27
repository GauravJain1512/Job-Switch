package com.spring.security.jwt.two.model;

import lombok.Builder;

@Builder
public class JwtResponse {
	
	private String token;
	
	private String status;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JwtResponse(String token, String status) {
		super();
		this.token = token;
		this.status = status;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
