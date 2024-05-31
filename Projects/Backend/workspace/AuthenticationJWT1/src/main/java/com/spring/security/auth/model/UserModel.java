package com.spring.security.auth.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserModel {
	
	@Size(min = 2, max = 50, message = "username length should be between 2 to 50 char")
	@NotBlank
	private String username;
	
	@Email(message = "Please enter valid email")
	@NotNull
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String city;
	

}
