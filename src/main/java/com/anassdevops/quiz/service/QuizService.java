package com.anassdevops.quiz.service;

import java.util.List;

import com.anassdevops.quiz.dto.QuizDTO;
import com.anassdevops.quiz.entity.Quiz;

public interface QuizService {
	
	List<Quiz> getQuizzes();
	List<Quiz> getQuizzesByCategoryId(Long id);

	Quiz addQuiz(QuizDTO quiz);

}
