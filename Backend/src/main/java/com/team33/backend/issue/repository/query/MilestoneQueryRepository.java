package com.team33.backend.issue.repository.query;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team33.backend.issue.controller.dto.MilestoneCount;
import com.team33.backend.issue.domain.QIssue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MilestoneQueryRepository {

    private final JPAQueryFactory queryFactory;

    public MilestoneCount countIssueMilestoneCount(Long milestoneId) {
        QIssue qIssue = new QIssue("qIssue");
        return queryFactory.select(Projections.fields(MilestoneCount.class,
                        qIssue.count().as("count")))
                .from(qIssue)
                .where(qIssue.milestone.id.eq(milestoneId))
                .fetchOne();
    }
}
