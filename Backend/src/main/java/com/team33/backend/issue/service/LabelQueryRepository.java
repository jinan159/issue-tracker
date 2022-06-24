package com.team33.backend.issue.service;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team33.backend.issue.controller.dto.milestone.MilestoneCount;
import com.team33.backend.issue.domain.Label;
import com.team33.backend.issue.domain.QIssue;
import com.team33.backend.issue.domain.QLabel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.team33.backend.issue.domain.QIssueLabel.issueLabel;

@Repository
@RequiredArgsConstructor
public class LabelQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<Label> getLablesByIssueId(Long issueId) {
        return null;
    }
}
