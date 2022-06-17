package com.team33.backend.domain;

import com.team33.backend.issue.domain.Assignee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigneeRepository extends JpaRepository<Assignee, Long> {
}
