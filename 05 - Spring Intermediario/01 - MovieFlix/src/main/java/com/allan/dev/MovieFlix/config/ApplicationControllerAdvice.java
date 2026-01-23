package com.allan.dev.MovieFlix.config;


import com.allan.dev.MovieFlix.exception.LoginOuSenhaInvalidos;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(LoginOuSenhaInvalidos.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundException(LoginOuSenhaInvalidos e){
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleArgumentNotValueException(MethodArgumentNotValidException e){

        Map<String, String> erros = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            erros.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return erros;

    }

}
