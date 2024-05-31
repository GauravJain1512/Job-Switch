package com.spring.security.h2.jwt.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ErrorDetails {
	
	private String message;
	
	private Date timestamp;
	
	private String desc;

}
