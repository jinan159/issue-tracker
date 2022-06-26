package com.team33.backend.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IssueTrackerRuntimeException.class)
    public ResponseEntity<ErrorResponse> businessException(IssueTrackerRuntimeException exception) {

        log.error(exception.getMessage(), exception);

        return ResponseEntity.status(exception.getStatus())
                .body(ErrorResponse.create(exception));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> unresolvedException(Exception exception) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        log.error(exception.getMessage(), exception);

        return ResponseEntity.status(internalServerError)
                .body(new ErrorResponse("0000", "처리되지 않은 예외가 발생하였습니다.", internalServerError));
    }
}
