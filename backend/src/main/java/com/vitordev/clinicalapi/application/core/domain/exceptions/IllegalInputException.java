package com.vitordev.clinicalapi.application.core.domain.exceptions;

public class IllegalInputException extends RuntimeException {
    public IllegalInputException(String message) {
        super(message);
    }
}
