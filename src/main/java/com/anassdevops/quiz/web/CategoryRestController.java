package com.anassdevops.quiz.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoryRestController {
	
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategories() throws Exception {
		List<Category> categories = categoryService.getCategories();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK) ;
	}

	@PostMapping
	//@PostAuthorize("hasAuthority('USER')")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.addCategory(category), HttpStatus.CREATED);
	}
	
	@PutMapping
	//@PostAuthorize("hasAuthority('USER')")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.updateCategory(category), HttpStatus.OK);
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
//		categoryService.deleteCategory(id);
//		return new ResponseEntity<String>("The Category " + id + " Has Deleted Successfly", HttpStatus.OK);
//	}
	
	@DeleteMapping("/{id}")
	//@PostAuthorize("hasAuthority('USER')")
	public List<String> deleteCategory(@PathVariable Long id) {
		List<String> res = new ArrayList<>();
		categoryService.deleteCategory(id);
		res.add("The Category Has Deleted Successfly");
		return res;
	}
}
