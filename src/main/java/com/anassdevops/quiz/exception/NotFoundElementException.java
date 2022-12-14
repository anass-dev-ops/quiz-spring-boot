package com.anassdevops.quiz.exception;

import org.springframework.http.HttpStatus;

public class NotFoundElementException extends GlobalException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundElementException(Long id) {
		super("It does not exist the element with ID " + id);
	}

	@Override
	HttpStatus getCodeStatus() {
		return HttpStatus.NOT_FOUND;
	}

}
