package com.anassdevops.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anassdevops.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
