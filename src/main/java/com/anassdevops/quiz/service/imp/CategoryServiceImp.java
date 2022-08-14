package com.anassdevops.quiz.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.repository.CategoryRepository;
import com.anassdevops.quiz.service.CategoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService{
	
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void editCategory(Category category) {
		
	}

	@Override
	public void deleteCategory(Long id) {
		
	}

}
