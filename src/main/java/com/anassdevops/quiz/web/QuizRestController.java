package com.anassdevops.quiz.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anassdevops.quiz.entity.Quiz;
import com.anassdevops.quiz.service.QuizService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/quizzes")
@AllArgsConstructor
public class QuizRestController {

	QuizService quizService;
	
	@GetMapping
	public List<Quiz> getQuizzes() {
		return quizService.getQuizzes();
	}
	
	@PostMapping
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return quizService.addQuiz(quiz);
	}
}
