package com.allan.dev.MovieFlix.config;


import com.allan.dev.MovieFlix.exception.LoginOuSenhaInvalidos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(LoginOuSenhaInvalidos.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundException(LoginOuSenhaInvalidos e){
        return e.getMessage();
    }

}
