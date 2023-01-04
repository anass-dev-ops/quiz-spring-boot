package com.anassdevops.quiz.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "quizzes")
@Data @NoArgsConstructor @AllArgsConstructor
public class Quiz {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 3)
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "details")
	private String details;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "quiz")
	private List<Question> questions;

}
