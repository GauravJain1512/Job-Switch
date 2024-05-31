package com.spring.security.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.auth.model.CategoryModel;
import com.spring.security.auth.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/categories")
	public ResponseEntity<Object> saveCategory(@Valid @RequestBody CategoryModel categoryModel){
		
		CategoryModel savedCategory = categoryService.saveCategory(categoryModel);
		return new ResponseEntity<Object>(savedCategory, HttpStatus.OK);
		
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Object> getAllCategories(){
		List<CategoryModel> allCategories = categoryService.getAllCategories();
		return new ResponseEntity<Object>(allCategories, HttpStatus.OK);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<Object> updateCategory(@PathVariable Long categoryId, @Valid @RequestBody CategoryModel categoryModel){
		
		CategoryModel updatedCategory = categoryService.updateCategory(categoryModel, categoryId);
		return new ResponseEntity<Object>(updatedCategory, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Object> deleteCategory(@PathVariable Long categoryId){
		
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}







