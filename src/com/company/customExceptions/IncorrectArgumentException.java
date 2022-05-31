package com.company.customExceptions;


public class IncorrectArgumentException extends RuntimeException {
    public IncorrectArgumentException(String errorMessage) {
        super(errorMessage);
    }
}