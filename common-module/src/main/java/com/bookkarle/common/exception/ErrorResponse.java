package com.bookkarle.common.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    String title;
    String message;
    LocalDateTime dateTime;
    public ErrorResponse(String title,String message){
        this.title=title;
        this.message=message;
    }
}
