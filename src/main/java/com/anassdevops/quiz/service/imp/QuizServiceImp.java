package com.anassdevops.quiz.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anassdevops.quiz.dto.QuizDTO;
import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.entity.Quiz;
import com.anassdevops.quiz.repository.CategoryRepository;
import com.anassdevops.quiz.repository.QuizRepository;
import com.anassdevops.quiz.service.QuizService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuizServiceImp implements QuizService{
	
	QuizRepository quizRepository;
	CategoryRepository categoryRepository;

	@Override
	public List<Quiz> getQuizzes() {
		return quizRepository.findAll();
	}

	@Override
	public Quiz addQuiz(QuizDTO quiz) {
		Quiz q = new Quiz();
		q.setDescription(quiz.getDescription());
		q.setDetails(quiz.getDetails());
		q.setTitle(quiz.getTitle());
		
		Category c = categoryRepository.findById(Long.parseLong(quiz.getCategoryId())).get();
		q.setCategory(c);
		return quizRepository.save(q);
	}

}
