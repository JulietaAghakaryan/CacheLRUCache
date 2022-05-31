package com.company.customExceptions;

public class NegativeInputException extends RuntimeException {
    public NegativeInputException(String errorMessage) {
        super(errorMessage);
    }
}
