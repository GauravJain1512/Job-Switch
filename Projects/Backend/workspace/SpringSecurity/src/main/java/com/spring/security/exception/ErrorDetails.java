package com.spring.security.exception;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
	
	private String message;
	
	private Date timeStamp;
	
	private String details;
	

}