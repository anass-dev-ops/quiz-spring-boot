package com.anassdevops.quiz.service;

import java.util.List;

import com.anassdevops.quiz.entity.Category;


public interface CategoryService {
	
	List<Category> getCategories();
	
	Category getCategoryById(Long id);
	
	Category addCategory(Category category);
	
	Category updateCategory(Category category);
	
	void deleteCategory(Long id);
	
}
