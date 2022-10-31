package com.anassdevops.quiz.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.exception.ConflictException;
import com.anassdevops.quiz.exception.NoDataFoundException;
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
		List<Category> categories = categoryRepository.findAll();
		if(categories.isEmpty()) {
			throw new NoDataFoundException();
		}
		return categories;
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundElementException(id));
	}

	@Override
	public Category addCategory(Category category) {
		Optional<Category> categoty = categoryRepository
				.findCategoryByName(category.getName());
		if (categoty.isPresent()) {
			throw new ConflictException(category.getName());
		}
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		categoryRepository.findById(category.getId())
		.orElseThrow(() -> new NotFoundElementException(category.getId()));
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.findById(id)
		.orElseThrow(() -> new NotFoundElementException(id));
		categoryRepository.deleteById(id);
	}


}
