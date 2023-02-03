package com.anassdevops.quiz.exception;

import org.springframework.http.HttpStatus;

public class ConfirmPassException extends GlobalException{


    public ConfirmPassException() {
        super( "Password confirmation doesn't match Password ");
    }

    @Override
    HttpStatus getCodeStatus() {
        return HttpStatus.BAD_REQUEST;
    }


}
