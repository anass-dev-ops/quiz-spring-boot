package com.anassdevops.quiz.service;

import java.util.List;

import com.anassdevops.quiz.entity.Question;

public interface QuestionService {
	
	List<Question> getQuestions(Long quizId);

}
