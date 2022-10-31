package com.anassdevops.quiz.exception;

import org.springframework.http.HttpStatus;

public class NoDataFoundException extends GlobalException{

	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {
		super("No Data Found");
	}

	@Override
	HttpStatus getCodeStatus() {
		return HttpStatus.NOT_FOUND;
	}

}
