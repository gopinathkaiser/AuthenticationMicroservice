package com.quiz.apigateway.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidAccessException(InvalidAccessException ia){
        return new ResponseEntity<>(ia.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
