package com.team33.backend.common.exception.issue;

import com.team33.backend.common.exception.IssueTrackerRuntimeException;

public abstract class IssueRuntimeException extends IssueTrackerRuntimeException {

    public IssueRuntimeException(String message) {
        super(message);
    }

    public IssueRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
