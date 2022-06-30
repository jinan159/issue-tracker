package com.team33.backend.issue.repository;

import com.team33.backend.issue.domain.Issue;
import com.team33.backend.issue.domain.IssueStatus;
import com.team33.backend.issuegroup.domain.IssueGroup;
import com.team33.backend.issuegroup.repository.IssueGroupRepository;
import com.team33.backend.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class IssueRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private IssueGroupRepository issueGroupRepository;

    @Autowired
    private IssueRepository issueRepository;

    private IssueRepositoryUtils issueRepositoryUtils;

    @BeforeEach
    void setUp() {
        issueRepository.deleteAll();
        memberRepository.deleteAll();
        issueGroupRepository.deleteAll();

        issueRepositoryUtils = new IssueRepositoryUtils(memberRepository, issueGroupRepository, issueRepository);
    }

    @Nested
    @DisplayName("이슈개수 조회는")
    class CountByIssueStatusTest {

        @Test
        void 열린_이슈가_없을때_열린이슈개수는_0_이다() {
            // given
            long issueGroupId = 1L;
            int expectedCount = 0;

            // when
            int openIssueCount = issueRepository.countByIssueGroupIdAndIssueStatus(issueGroupId, IssueStatus.OPEN);

            // then
            assertThat(openIssueCount).isEqualTo(expectedCount);
        }

        @Test
        void 닫힌_이슈가_없을때_닫힌이슈개수는_0_이다() {
            // given
            long issueGroupId = 1L;
            int expectedCount = 0;

            // when
            int openIssueCount = issueRepository.countByIssueGroupIdAndIssueStatus(issueGroupId, IssueStatus.CLOSED);

            // then
            assertThat(openIssueCount).isEqualTo(expectedCount);
        }

        @Test
        void 열린_이슈가_1개_있으면_열린이슈개수개수는_1_이다() {
            // given
            IssueGroup issueGroup = issueRepositoryUtils.saveNewIssueGroup();
            issueRepositoryUtils.saveNewIssue(issueGroup, IssueStatus.OPEN);
            int expectedCount = 1;

            // when
            int openIssueCount = issueRepository.countByIssueGroupIdAndIssueStatus(issueGroup.getId(), IssueStatus.OPEN);

            // then
            assertThat(openIssueCount).isEqualTo(expectedCount);
        }

        @Test
        void 닫힌_이슈가_1개_있으면_닫힌이슈개수는_1_이다() {
            // given
            IssueStatus closed = IssueStatus.CLOSED;
            IssueGroup issueGroup = issueRepositoryUtils.saveNewIssueGroup();
            Issue issue = issueRepositoryUtils.saveNewIssue(issueGroup, closed);
            int expectedCount = 1;

            // when
            int openIssueCount = issueRepository.countByIssueGroupIdAndIssueStatus(issueGroup.getId(), closed);

            // then
            assertThat(openIssueCount).isEqualTo(expectedCount);
        }
    }

    @Nested
    @DisplayName("이슈 상태에 따른 이슈 조회는")
    class FindAllByIssueStatusTest {

        @Test
        void 열린_이슈_조회시_열린_이슈가_1개_있으면_1개인_리스트를_반환한다() {
            // given
            int expectedSize = 1;
            IssueStatus status = IssueStatus.OPEN;
            Issue savedIssue = issueRepositoryUtils.saveNewIssue(status);
            IssueGroup issueGroup = savedIssue.getIssueGroup();

            // when
            List<Issue> issues = issueRepository.findAllByIssueGroupIdAndIssueStatus(issueGroup.getId(), status, Pageable.unpaged());

            // then
            assertThat(issues).isNotNull();
            assertThat(issues).isNotEmpty();
            assertThat(issues).size().isEqualTo(expectedSize);
            for (Issue issue : issues) {
                assertIssue(issue, savedIssue);
            }
        }

        @Test
        void 닫힌_이슈_조회시_닫힌_이슈가_1개_있으면_1개인_리스트를_반환한다() {
            // given
            int expectedSize = 1;
            IssueStatus status = IssueStatus.CLOSED;
            Issue savedIssue = issueRepositoryUtils.saveNewIssue(status);
            IssueGroup issueGroup = savedIssue.getIssueGroup();

            // when
            List<Issue> issues = issueRepository.findAllByIssueGroupIdAndIssueStatus(issueGroup.getId(), status, Pageable.unpaged());

            // then
            assertThat(issues).isNotNull();
            assertThat(issues).isNotEmpty();
            assertThat(issues).size().isEqualTo(expectedSize);
            for (Issue issue : issues) {
                assertIssue(issue, savedIssue);
            }
        }

        @Test
        void 이슈가_없으면_빈_리스트를_반환한다() {
            // given
            long issueGroupId = 1L;
            IssueStatus open = IssueStatus.OPEN;
            Pageable pageable = Pageable.unpaged();

            // when
            List<Issue> issues = issueRepository.findAllByIssueGroupIdAndIssueStatus(issueGroupId, open, pageable);

            // then
            assertThat(issues).isNotNull();
            assertThat(issues).isEmpty();
        }
    }

    private void assertIssue(Issue issue, Issue savedIssue) {
        assertThat(issue.getId()).isEqualTo(savedIssue.getId());
        assertThat(issue.getTitle()).isEqualTo(savedIssue.getTitle());
        assertThat(issue.getIssueStatus()).isEqualTo(savedIssue.getIssueStatus());
        assertThat(issue.getAuthor()).isNotNull();
        assertThat(issue.getAuthor().getId()).isEqualTo(savedIssue.getAuthor().getId());
        assertThat(issue.getAuthor().getName()).isEqualTo(savedIssue.getAuthor().getName());
        assertThat(issue.getAuthor().getProfileImageUrl()).isEqualTo(savedIssue.getAuthor().getProfileImageUrl());
        assertThat(issue.getIssueGroup()).isNotNull();
        assertThat(issue.getIssueGroup().getId()).isEqualTo(savedIssue.getIssueGroup().getId());
        assertThat(issue.getIssueGroup().getName()).isEqualTo(savedIssue.getIssueGroup().getName());
    }
}