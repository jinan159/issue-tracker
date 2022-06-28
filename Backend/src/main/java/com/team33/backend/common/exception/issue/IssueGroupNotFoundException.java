package com.team33.backend.common.exception.issue;

import com.team33.backend.common.exception.IssueTrackerRuntimeException;
import org.springframework.http.HttpStatus;

public class IssueGroupNotFoundException extends IssueTrackerRuntimeException {

    private static final String ERROR_CODE = "I003";
    private static final String ERROR_MSG = "이슈 그룹을 찾을 수 없습니다.";
    private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

    public IssueGroupNotFoundException() {
        super(ERROR_MSG);
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
