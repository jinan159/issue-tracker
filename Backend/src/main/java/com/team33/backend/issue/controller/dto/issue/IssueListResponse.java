package com.team33.backend.issue.controller.dto.issue;

import lombok.Getter;

import java.util.List;

@Getter
public class IssueListResponse {

    private final int openIssueCount;
    private final int closedIssueCount;

    private final List<IssueResponse> issues;

    public IssueListResponse(List<IssueResponse> issues, int openIssueCount, int closedIssueCount) {
        this.issues = issues;
        this.openIssueCount = openIssueCount;
        this.closedIssueCount = closedIssueCount;
    }
}
