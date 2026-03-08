package com.allan_dev.Event.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> eventoDuplicado(DuplicateEventException ex){
        Map<String, String> response = new HashMap<>();

        response.put("Error:", "Conflito no identificador do evento");
        response.put("Message: ", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EventNotFound.class)
    public ResponseEntity<Map<String, String>> eventoNaoEncontrado(EventNotFound ex){
        Map<String, String> response = new HashMap<>();

        response.put("Error:", "Evento não encontrado");
        response.put("Message: ", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
