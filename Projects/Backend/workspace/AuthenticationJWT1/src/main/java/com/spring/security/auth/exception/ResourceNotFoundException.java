package com.spring.security.auth.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String field;
	
	private String fieldName;
	
	private Object fieldValue;

	public ResourceNotFoundException(String field, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s: %s", field, fieldName, fieldValue));
		this.field = field;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	

}
