package com.anassdevops.quiz.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.exception.NotFoundElementException;
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
		return categoryRepository.findById(id).orElseThrow(() -> new NotFoundElementException(id));
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
