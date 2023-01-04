package com.anassdevops.quiz.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "questions")
@Data @NoArgsConstructor @AllArgsConstructor
public class Question {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "description")
	private String description;

	@NotEmpty
	@Column(name = "option1")
	private String option1;
	@Size(min = 1)
	@Column(name = "option2")
	private String option2;

	@Column(name = "option3")
	private String option3;

	@Column(name = "option4")
	private String option4;
	@Enumerated(EnumType.STRING)
	@Column(name = "correct_answer")
	private CorrectAnswer correctAnswer;
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Quiz quiz;
}

