package com.team33.backend.issue.repository.query;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team33.backend.issue.domain.Issue;
import com.team33.backend.issue.domain.IssueStatus;
import com.team33.backend.issue.domain.QIssue;
import com.team33.backend.issue.domain.filter.IssueFilter;
import com.team33.backend.issuegroup.domain.IssueGroup;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssueFilterQueryRepository extends QuerydslRepositorySupport {

    private static QIssue issue = QIssue.issue;

    private final JPAQueryFactory queryFactory;

    public IssueFilterQueryRepository(JPAQueryFactory queryFactory) {
        super(Issue.class);
        this.queryFactory = queryFactory;
    }

    public List<Issue> findAllFilteredIssues(List<IssueFilter> issueFilters, long issueGroupId, Pageable pageable) {
        JPAQuery<Issue> filteredIssuesQuery = queryFactory.selectFrom(issue)
                .where(issue.issueGroup.id.eq(issueGroupId));

        for (IssueFilter issueFilter : issueFilters) {
            BooleanExpression condition = convertFilterToConditionOrNull(issueFilter);
            if (condition != null) {
                filteredIssuesQuery.where(condition);
            }
        }

        Querydsl querydsl = getQuerydsl();

        return querydsl.applyPagination(pageable, filteredIssuesQuery)
                .fetch();
    }

    private BooleanExpression convertFilterToConditionOrNull(IssueFilter issueFilter) {

        JPAQuery<?> query = queryFactory.query();

        switch (issueFilter) {
            case OPEN: return issue.issueStatus.eq(IssueStatus.OPEN);
            case CLOSED: return issue.issueStatus.eq(IssueStatus.CLOSED);
            // TODO : 요청자의 회원 ID 를 가져올 수 있게 되면, 나머지 enum 의 where 구문 매핑하기
            default: return null;
        }
    }
}
