package com.anassdevops.quiz.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "questions")
@Data @NoArgsConstructor @AllArgsConstructor
public class Question {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	@Enumerated(EnumType.STRING)
	private CorrectAnswer correctAnswer;
	@ManyToOne
	private Quiz quiz;
}

