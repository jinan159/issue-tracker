package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.MemberResponse;
import com.team33.backend.issue.controller.dto.issue.IssueListRequest;
import com.team33.backend.issue.controller.dto.issue.IssueListResponse;
import com.team33.backend.issue.controller.dto.issue.IssueResponse;
import com.team33.backend.issue.controller.dto.label.LabelResponse;
import com.team33.backend.issue.domain.Issue;
import com.team33.backend.issue.domain.IssueStatus;
import com.team33.backend.issue.repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    @Transactional(readOnly = true)
    public IssueListResponse findAllIssueWithStatus(IssueListRequest request) {

        List<Issue> issues = issueRepository.findAllByIssueStatus(request.getStatus(), request.getPageable());

        List<IssueResponse> issueResponses = getIssueResponses(issues);

        return new IssueListResponse(
                issueResponses,
                countIssueByStatus(IssueStatus.OPEN),
                countIssueByStatus(IssueStatus.CLOSED)
        );
    }

    private List<IssueResponse> getIssueResponses(List<Issue> issues) {
        return issues.stream()
                .map(issue -> new IssueResponse(issue, getLabelResponseList(issue), getMemberResponseList(issue)))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<MemberResponse> getMemberResponseList(Issue issue) {
        return issue.getAssignees()
                .stream()
                .map(assignee -> MemberResponse.from(assignee.getMember()))
                .collect(Collectors.toList());
    }

    private List<LabelResponse> getLabelResponseList(Issue issue) {
        return issue.getLabels()
                .stream()
                .map(label -> LabelResponse.from(label.getLabel()))
                .collect(Collectors.toList());
    }

    private int countIssueByStatus(IssueStatus status) {
        return issueRepository.countByIssueStatus(status);
    }

}
