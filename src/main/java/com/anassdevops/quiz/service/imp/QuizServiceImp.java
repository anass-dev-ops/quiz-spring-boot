package com.anassdevops.quiz.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anassdevops.quiz.entity.Quiz;
import com.anassdevops.quiz.repository.QuizRepository;
import com.anassdevops.quiz.service.QuizService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuizServiceImp implements QuizService{
	
	QuizRepository quizRepository;

	@Override
	public List<Quiz> getQuizzes() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

}
