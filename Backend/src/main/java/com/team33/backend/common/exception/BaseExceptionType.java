package com.team33.backend.common.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptionType {
    int getErrorCode();

    String getErrorMessage();

    HttpStatus getHttpStatus();
}
