package com.bookkarle.common.exception;

public class OperationFailedException extends RuntimeException{
    public OperationFailedException(String message){
        super(message);
    }
}
