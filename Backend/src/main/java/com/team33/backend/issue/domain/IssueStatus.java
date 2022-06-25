package com.team33.backend.issue.domain;

import com.team33.backend.common.exception.issue.IllegalIssueStatusException;

public enum IssueStatus {
    OPEN,
    CLOSED;

    public static IssueStatus parse(String name) {
        try {
            return IssueStatus.valueOf(name);
        } catch (IllegalArgumentException e) {
            throw new IllegalIssueStatusException(e);
        }
    }
}
