package com.spring.security.auth.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryModel {
	
	private Long categoryId;
	
	@Size(min = 2, max = 50, message = "Please enter valid category name")
	private String categoryName;

}
