package com.example.productAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productAndCategories.models.Category;
import com.example.productAndCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	public final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	//create Category
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	//show all Categories
	public List<Category>allCategory(){
		return categoryRepository.findAll();
	}
	//find One Category
	public Category getOneCategory(Long id) {
		Optional<Category>category=categoryRepository.findById(id);
		return category.isPresent()?category.get():null;
	}//save Category
	public Category saveCategory(Category c) {
		return categoryRepository.save(c);
	}
}
