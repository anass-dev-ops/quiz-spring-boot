package com.anassdevops.quiz.exception;

import org.springframework.http.HttpStatus;

public class NotFoundElementException extends GlobalException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundElementException(Long id) {
		super("The Element With Id " + id + " is not Existe");
	}

	@Override
	HttpStatus getCodeStatus() {
		return HttpStatus.NOT_FOUND;
	}

}
