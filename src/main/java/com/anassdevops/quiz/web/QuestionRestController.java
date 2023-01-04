package com.anassdevops.quiz.web;

import java.util.List;

import com.anassdevops.quiz.dto.QuestionDTO;
import org.springframework.web.bind.annotation.*;

import com.anassdevops.quiz.entity.Question;
import com.anassdevops.quiz.service.QuestionService;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("api/questions")
@AllArgsConstructor
@CrossOrigin("*")
public class QuestionRestController {
	
	QuestionService questionService;
	
	@GetMapping("/quizzes/{quizId}")
	List<Question> getQuestionsByQuizId(@PathVariable String quizId) {
		return questionService.getQuestionsByQuizId(quizId);
	}

	@GetMapping("/{id}")
	Question getQuestionsById(@PathVariable String id) {
		return questionService.getQuestionsById(id);
	}

	@PostMapping
	Question addQuestion(@Valid @RequestBody QuestionDTO question) {
		return questionService.addQuestion(question);
	}

	@PutMapping
	Question updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}

	@GetMapping
	List<Question> getQuestions() {
		return questionService.getQuestions();
	}

}
