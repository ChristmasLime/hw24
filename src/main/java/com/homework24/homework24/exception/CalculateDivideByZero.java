package com.homework24.homework24.exception;


public class CalculateDivideByZero extends IllegalArgumentException{
    public CalculateDivideByZero() {
    }

    public CalculateDivideByZero(String s) {
        super(s);
    }

    public CalculateDivideByZero(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculateDivideByZero(Throwable cause) {
        super(cause);
    }
}
