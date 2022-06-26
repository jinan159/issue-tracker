package com.team33.backend.common.exception.issue;

import org.springframework.http.HttpStatus;

public class FilterParseException extends IssueRuntimeException {

    private static final String ERROR_CODE = "I002";
    private static final String ERROR_MSG = "잘못된 필터입니다.";
    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
    public FilterParseException() {
        super(ERROR_MSG);
    }

    public FilterParseException(Throwable cause) {
        super(ERROR_MSG, cause);
    }

    @Override
    protected String getErrorCode() {
        return ERROR_CODE;
    }

    @Override
    protected HttpStatus getStatus() {
        return HTTP_STATUS;
    }
}
