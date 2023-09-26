package com.bookkarle;

public class BusinessValidationException extends RuntimeException{
    public BusinessValidationException(String message){
        super(message);
    }
}
