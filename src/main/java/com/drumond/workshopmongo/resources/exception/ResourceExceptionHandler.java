package com.drumond.workshopmongo.resources.exception;

import com.drumond.workshopmongo.services.exception.ObjectNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Custom error handling when and invalid ID is inserted.
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(@NotNull ObjectNotFoundException objectNotFoundException, @NotNull HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Não encontrado", objectNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
}