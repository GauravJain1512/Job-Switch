package com.spring.security.jwt.three.security.exception;

public class JwtException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public JwtException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtException(String message) {
		super(message);
		this.message = message;
	}
	
	

}
