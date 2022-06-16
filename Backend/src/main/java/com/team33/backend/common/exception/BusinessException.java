package com.team33.backend.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final BaseExceptionType baseExceptionType;

    public BusinessException(BaseExceptionType baseExceptionType) {
        this.baseExceptionType = baseExceptionType;
    }
}
