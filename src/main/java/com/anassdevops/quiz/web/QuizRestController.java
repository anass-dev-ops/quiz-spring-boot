package com.anassdevops.quiz.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.anassdevops.quiz.dto.QuizDTO;
import com.anassdevops.quiz.entity.Quiz;
import com.anassdevops.quiz.service.QuizService;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("api/quizzes")
@AllArgsConstructor
@CrossOrigin("*")
public class QuizRestController {

	QuizService quizService;
	
	@GetMapping
	public List<Quiz> getQuizzes() {
		return quizService.getQuizzes();
	}
	@GetMapping("/{id}")
	public List<Quiz> getQuizzesByCategoryId(@PathVariable Long id) {
		return quizService.getQuizzesByCategoryId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Quiz addQuiz(@Valid @RequestBody QuizDTO quiz) {
		return quizService.addQuiz(quiz);
	}
}
