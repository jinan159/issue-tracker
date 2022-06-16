package com.team33.backend.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessException(BusinessException exception) {
        BaseExceptionType baseExceptionType = exception.getBaseExceptionType();
        return ResponseEntity.status(NOT_FOUND)
                .body(ErrorResponse.create(baseExceptionType));
    }
}
