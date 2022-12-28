package com.anassdevops.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anassdevops.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	List<Question> findByQuizId(Long quizId);

}
