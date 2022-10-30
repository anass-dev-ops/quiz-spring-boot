package com.anassdevops.quiz.exception;

import org.springframework.http.HttpStatus;

abstract public class GlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public GlobalException(String msg) {
		super(msg);
	}
	
	abstract HttpStatus getCodeStatus();

}
