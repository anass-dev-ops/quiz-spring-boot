package com.anassdevops.quiz.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "quizzes")
@Data @NoArgsConstructor @AllArgsConstructor
public class Quiz {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String details;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "quiz")
	private List<Question> questions;

}
