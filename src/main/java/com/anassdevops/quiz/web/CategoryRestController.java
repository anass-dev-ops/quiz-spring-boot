package com.anassdevops.quiz.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CategoryRestController {
	
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping("/categories/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping("/categories")
	public String addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return "The Category Has Added Successfly";
	}
}
