package com.team33.backend.issue.controller.dto.issue;

import com.team33.backend.issue.domain.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@AllArgsConstructor
public class IssueListRequest {

    private final Pageable pageable;
    private final IssueStatus status;
    private final long issueGroupId;
}
