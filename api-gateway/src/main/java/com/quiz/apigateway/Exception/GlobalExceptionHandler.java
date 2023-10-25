package com.quiz.apigateway.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = InvalidAccessException.class)
    public ResponseEntity<?> handleInvalidAccessException(){
        return new ResponseEntity<>("Invalid access", HttpStatus.UNAUTHORIZED);
    }
}
