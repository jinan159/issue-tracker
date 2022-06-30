package com.team33.backend.issue.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team33.backend.issue.domain.Issue;
import com.team33.backend.issue.domain.IssueStatus;
import com.team33.backend.issue.domain.filter.IssueFilter;
import com.team33.backend.issue.repository.IssueRepository;
import com.team33.backend.issue.repository.IssueRepositoryUtils;
import com.team33.backend.issuegroup.domain.IssueGroup;
import com.team33.backend.issuegroup.repository.IssueGroupRepository;
import com.team33.backend.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class IssueFilterQueryRepositoryTest {

    @Autowired
    private EntityManager em;

    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private IssueGroupRepository issueGroupRepository;

    @Autowired
    private IssueRepository issueRepository;

    private IssueRepositoryUtils issueRepositoryUtils;

    private IssueFilterQueryRepository issueFilterQueryRepository;

    @BeforeEach
    void setUp() {
        issueRepository.deleteAll();
        memberRepository.deleteAll();
        issueGroupRepository.deleteAll();

        issueRepositoryUtils = new IssueRepositoryUtils(memberRepository, issueGroupRepository, issueRepository);

        jpaQueryFactory = new JPAQueryFactory(em);
        issueFilterQueryRepository = new IssueFilterQueryRepository(jpaQueryFactory);
        issueFilterQueryRepository.setEntityManager(em); // for QuerydslRepositorySupport
    }
    
    @Test
    void 열린_이슈_3개가_있을_때_열린이슈필터로_조회하면_이슈_3개가_반환된다() {
        // given
        List<IssueFilter> filters = List.of(IssueFilter.OPEN);

        IssueStatus open = IssueStatus.OPEN;
        IssueGroup issueGroup = issueRepositoryUtils.saveNewIssueGroup();

        issueRepositoryUtils.saveNewIssue(issueGroup, open);
        issueRepositoryUtils.saveNewIssue(issueGroup, open);
        issueRepositoryUtils.saveNewIssue(issueGroup, open);

        int expectedSize = 3;

        // when
        List<Issue> filteredIssues = 
                issueFilterQueryRepository.findAllFilteredIssues(filters, issueGroup.getId(), Pageable.unpaged());

        // then
        assertThat(filteredIssues).isNotNull();
        assertThat(filteredIssues).isNotEmpty();
        assertThat(filteredIssues).size().isEqualTo(expectedSize);
    }

    @Test
    void 닫힌_이슈_3개가_있을_때_닫힌이슈필터로_조회하면_이슈_3개가_반환된다() {
        // given
        List<IssueFilter> filters = List.of(IssueFilter.CLOSED);

        IssueStatus closed = IssueStatus.CLOSED;
        IssueGroup issueGroup = issueRepositoryUtils.saveNewIssueGroup();

        issueRepositoryUtils.saveNewIssue(issueGroup, closed);
        issueRepositoryUtils.saveNewIssue(issueGroup, closed);
        issueRepositoryUtils.saveNewIssue(issueGroup, closed);

        int expectedSize = 3;

        // when
        List<Issue> filteredIssues =
                issueFilterQueryRepository.findAllFilteredIssues(filters, issueGroup.getId(), Pageable.unpaged());

        // then
        assertThat(filteredIssues).isNotNull();
        assertThat(filteredIssues).isNotEmpty();
        assertThat(filteredIssues).size().isEqualTo(expectedSize);
    }
}