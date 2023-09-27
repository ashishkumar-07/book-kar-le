package com.bookkarle.common.exception;

public class BusinessValidationException extends RuntimeException{
    public BusinessValidationException(String message){
        super(message);
    }
}
