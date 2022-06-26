package com.team33.backend.issue.controller;

import com.team33.backend.issue.controller.dto.issue.IssueListRequest;
import com.team33.backend.issue.controller.dto.issue.IssueListResponse;
import com.team33.backend.issue.domain.IssueStatus;
import com.team33.backend.issue.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/issuegroup")
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/{issueGroupId}/issues")
    public IssueListResponse issueList(
            @PageableDefault Pageable pageable,
            @RequestParam("status") String status,
            @PathVariable("issueGroupId") long issueGroupId
    ) {
        IssueListRequest issueListRequest = new IssueListRequest(pageable, IssueStatus.parse(status), issueGroupId);

        return issueService.findAllIssueWithStatus(issueListRequest);
    }
}
