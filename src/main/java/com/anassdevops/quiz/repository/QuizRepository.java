package com.anassdevops.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anassdevops.quiz.entity.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

    public List<Quiz> findAllByCategoryId(Long id);
}
