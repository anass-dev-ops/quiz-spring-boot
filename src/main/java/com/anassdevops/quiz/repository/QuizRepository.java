package com.anassdevops.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anassdevops.quiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
