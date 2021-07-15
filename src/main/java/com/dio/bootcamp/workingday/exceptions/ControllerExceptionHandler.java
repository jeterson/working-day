package com.dio.bootcamp.workingday.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> notFound(EntityNotFoundException e, HttpServletRequest req) {
        ApiError error = new ApiError();
        error.setStatus(404);
        error.setMessage(e.getMessage());
        error.setPath(req.getRequestURI());
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validationException(MethodArgumentNotValidException e, HttpServletRequest req) {
        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setTimestamp(System.currentTimeMillis());
        apiError.setPath(req.getRequestURI());
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(e.getBindingResult().getFieldErrors());
        apiError.addValidationError(e.getBindingResult().getGlobalErrors());

        return ResponseEntity.status(400).body(apiError);
    }
}
