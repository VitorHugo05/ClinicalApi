package com.vitordev.clinicalapi.adapters.in.controllers.exception;

import com.vitordev.clinicalapi.application.core.domain.exceptions.AccessDeniedException;
import com.vitordev.clinicalapi.application.core.domain.exceptions.DataAlreadyExistException;
import com.vitordev.clinicalapi.application.core.domain.exceptions.IllegalInputException;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(HttpServletRequest request, ObjectNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity<StandardError> dataAlreadyExist(HttpServletRequest request, DataAlreadyExistException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Already registered user", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> accessDenied(AccessDeniedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Forbidden access", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(IllegalInputException.class)
    public ResponseEntity<StandardError> illegalException(AccessDeniedException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Illegal argument", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
