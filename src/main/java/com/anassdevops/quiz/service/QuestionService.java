package com.anassdevops.quiz.service;

import java.util.List;

import com.anassdevops.quiz.dto.QuestionDTO;
import com.anassdevops.quiz.entity.Question;

public interface QuestionService {
	
	List<Question> getQuestions();
	
	List<Question> getQuestionsByQuizId(String quizId);
	Question getQuestionsById(String id);

	Question addQuestion(QuestionDTO question);
	Question updateQuestion(Question question);

}
