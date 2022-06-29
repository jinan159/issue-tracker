package com.team33.backend.issue.repository;

import com.team33.backend.issue.domain.Issue;
import com.team33.backend.issue.domain.IssueStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    int countByIssueGroupIdAndIssueStatus(long issueGroupId, IssueStatus issueStatus);
    List<Issue> findAllByIssueGroupIdAndIssueStatus(long issueGroupId, IssueStatus issueStatus, Pageable pageable);
}
