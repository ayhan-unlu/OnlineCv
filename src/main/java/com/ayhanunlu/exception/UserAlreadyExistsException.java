package com.ayhanunlu.exception;

public class UserAlreadyExistsException extends BusinessException{
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
