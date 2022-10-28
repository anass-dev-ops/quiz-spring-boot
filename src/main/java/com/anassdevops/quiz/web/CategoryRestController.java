package com.anassdevops.quiz.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryRestController {
	
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategories() throws Exception {
		List<Category> categories = categoryService.getCategories();
//		if(categories.isEmpty()) {
//			throw new Exception("Is Not Empty");
//		}
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping
	public String addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		return "The Category Has Added Successfly";
	}
}
