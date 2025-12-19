package com.ayhanunlu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

public abstract class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
