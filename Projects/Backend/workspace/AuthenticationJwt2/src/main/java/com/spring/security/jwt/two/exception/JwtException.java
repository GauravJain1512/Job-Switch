package com.spring.security.jwt.two.exception;

public class JwtException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public JwtException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	

}
