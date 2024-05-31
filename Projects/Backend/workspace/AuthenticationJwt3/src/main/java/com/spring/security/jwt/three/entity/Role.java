package com.spring.security.jwt.three.entity;

public enum Role {
	ADMIN("ADMIN"),
	SELLER("SELLER"),
	CONSUMER("CONSUMER");
	
	private final String roleName;

	private Role(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}
	
	
	
}
