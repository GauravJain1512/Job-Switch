package com.spring.security.h2.jwt.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> sqlExceptionHandler(ConstraintViolationException sqlException, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(sqlException.getMessage(), new Date(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> sqlExceptionHandler2(DataIntegrityViolationException sqlException, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(sqlException.getMessage(), new Date(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request){
		Map<String, Object> result = new HashMap<>();
		
		exception.getBindingResult().getAllErrors().forEach(error->{
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			result.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,Object>>(result,HttpStatus.BAD_REQUEST);
	}

}
