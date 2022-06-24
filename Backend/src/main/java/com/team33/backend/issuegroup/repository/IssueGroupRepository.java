package com.team33.backend.issuegroup.repository;

import com.team33.backend.issuegroup.domain.IssueGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueGroupRepository extends JpaRepository<IssueGroup, Long> {
}
