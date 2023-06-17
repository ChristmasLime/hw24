package com.homework24.homework24.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)

public class CalculateVoidException extends RuntimeException{
    public CalculateVoidException() {
    }

    public CalculateVoidException(String message) {
        super(message);
    }

    public CalculateVoidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculateVoidException(Throwable cause) {
        super(cause);
    }

    public CalculateVoidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
