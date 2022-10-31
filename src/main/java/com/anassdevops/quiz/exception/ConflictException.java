package com.anassdevops.quiz.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends GlobalException{

	private static final long serialVersionUID = 1L;

	public ConflictException(String name) {
		super("The element " + name + " already exists");
	}

	@Override
	HttpStatus getCodeStatus() {
		return HttpStatus.CONFLICT;
	}

}
