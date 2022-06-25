package com.team33.backend.common.exception.issue;

import org.springframework.http.HttpStatus;

public class IllegalIssueStatusException extends IssueRuntimeException {

    private static final String ERROR_CODE = "I001";
    private static final String ERROR_MSG = "잘못된 이슈 상태입니다.";
    private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

    public IllegalIssueStatusException() {
        super(ERROR_MSG);
    }

    public IllegalIssueStatusException(Throwable cause) {
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
