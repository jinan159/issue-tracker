package com.team33.backend.issue.controller.dto.issue;

import com.team33.backend.issue.domain.IssueStatus;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
public class IssueListRequest {

    private final Pageable pageable;
    private final IssueStatus status;

    public IssueListRequest(Pageable pageable, String status) {
        this.pageable = pageable;
        this.status = IssueStatus.parse(status);
    }
}
