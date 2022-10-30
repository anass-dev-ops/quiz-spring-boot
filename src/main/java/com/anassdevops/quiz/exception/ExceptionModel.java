package com.anassdevops.quiz.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ExceptionModel {
	
	private String url;
	private String message;
	private LocalDateTime timestampe;

}
