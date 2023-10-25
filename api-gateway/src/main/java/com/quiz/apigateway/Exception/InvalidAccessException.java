package com.quiz.apigateway.Exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidAccessException extends RuntimeException{
    public InvalidAccessException(String message) {
        super(message);
        System.out.println("calling");
    }
}
