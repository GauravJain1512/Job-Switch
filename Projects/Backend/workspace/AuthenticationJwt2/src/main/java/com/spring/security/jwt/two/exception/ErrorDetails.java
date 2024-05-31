package com.spring.security.jwt.two.exception;

import java.util.Date;

public class ErrorDetails {
	
	private String message;
	
	private Date timestamp;
	
	private String desc;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String message, Date timestamp, String desc) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.desc = desc;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	

}
