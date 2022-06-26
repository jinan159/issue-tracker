package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.issue.IssueListRequest;
import com.team33.backend.issue.controller.dto.issue.IssueListResponse;
import com.team33.backend.issue.domain.IssueStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Sql(value = {"classpath:sql/Issue_label_assignee-data.sql"})
class IssueServiceTest {

    private final int OPEN_COUNT = 2;
    private final int CLOSED_COUNT = 0;
    private final int ISSUE_GROUP_ID = 1;

    @Autowired
    private IssueService issueService;

    @Test
    void 열린_이슈_조회시_열린_이슈가_2개_있으면_열린이슈_3개가_담긴_결과를_반환한다() {
        // given
        IssueStatus open = IssueStatus.OPEN;

        // when
        IssueListResponse issues = issueService.findAllIssueWithStatus(new IssueListRequest(Pageable.unpaged(), open, ISSUE_GROUP_ID));

        // then
        assertThat(issues).isNotNull();
        assertThat(issues.getOpenIssueCount()).isEqualTo(OPEN_COUNT);
        assertThat(issues.getClosedIssueCount()).isEqualTo(CLOSED_COUNT);
        assertThat(issues.getIssues()).isNotNull();
        assertThat(issues.getIssues()).size().isEqualTo(OPEN_COUNT);
    }

    @Test
    void 닫힌_이슈_조회시_열린_이슈가_2개_있으면_빈_이슈리스트가_담긴_결과를_반환한다() {
        // given
        IssueStatus closed = IssueStatus.CLOSED;

        // when
        IssueListResponse issues = issueService.findAllIssueWithStatus(new IssueListRequest(Pageable.unpaged(), closed, ISSUE_GROUP_ID));

        // then
        assertThat(issues).isNotNull();
        assertThat(issues.getOpenIssueCount()).isEqualTo(OPEN_COUNT);
        assertThat(issues.getClosedIssueCount()).isEqualTo(CLOSED_COUNT);
        assertThat(issues.getIssues()).isNotNull();
        assertThat(issues.getIssues()).size().isEqualTo(CLOSED_COUNT);
    }
}