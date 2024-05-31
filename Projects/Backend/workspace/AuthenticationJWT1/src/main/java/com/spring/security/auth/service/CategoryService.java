package com.spring.security.auth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.spring.security.auth.entity.Category;
import com.spring.security.auth.entity.Product;
import com.spring.security.auth.exception.ResourceNotFoundException;
import com.spring.security.auth.model.CategoryModel;
import com.spring.security.auth.repository.CategoryRepository;
import com.spring.security.auth.repository.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	public CategoryModel saveCategory(CategoryModel categoryModel) {
		
		Category category = mapper.map(categoryModel, Category.class);
		Category savedCategory = categoryRepository.save(category);
		return mapper.map(savedCategory, CategoryModel.class);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<CategoryModel> getAllCategories(){
		List<Category> categories = categoryRepository.findAll();
		return categories.stream().map(category -> mapper.map(category, CategoryModel.class))
				.collect(Collectors.toList());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public CategoryModel updateCategory(CategoryModel categoryModel, Long categoryId) {
		Category category = categoryRepository.findById(categoryId).
		orElseThrow(()-> new ResourceNotFoundException("Category","categoryId", categoryId));
		
		category.setCategoryName(categoryModel.getCategoryName());
		Category savedCategory = categoryRepository.save(category);
		return mapper.map(savedCategory, CategoryModel.class);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteCategory(Long categoryId) {
		Category category = categoryRepository.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<Product> products = productRepository.findByCategory(category);
		
		products.stream().forEach(product-> product.setCategory(null));

		productRepository.saveAll(products);
		categoryRepository.delete(category);
	}

}
