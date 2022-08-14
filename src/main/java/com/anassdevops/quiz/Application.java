package com.anassdevops.quiz;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class Application implements CommandLineRunner {
	
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Programming", "general Knowlegde", "Mathematic").forEach(c -> {
			Category category = new Category();
			category.setName(c);
			category.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut eget rhoncus nibh, non viverra massa. Nullam rutrum tincidunt est at bibendum. Duis interdum dolor a sem lobortis interdum");
			categoryRepository.save(category);
		});	
	}
	
	

}
