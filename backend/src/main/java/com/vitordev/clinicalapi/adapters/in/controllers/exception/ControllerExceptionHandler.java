package com.vitordev.clinicalapi.adapters.in.controllers.exception;

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
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
