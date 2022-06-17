package com.team33.backend.domain;

import com.team33.backend.issue.domain.Issue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IssueTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private AssigneeRepository assigneeRepository;

    @BeforeEach
    void setUp() {
        // 이슈의 Assignees 는 Null
        Issue issue = new Issue();

        // 영속화를 하는 시점에 PersistentBag으로 감싸진 상태
        issueRepository.save(issue);

        // 영속성 초기화
        entityManager.clear();
        entityManager.flush();
    }

    /**
     * 찾아오는 순간에 PersistentBag으로 감싸진 상태.
     * 실제 호출하더라도 빈 리스트가 반환
     */
    @Test
    @Transactional
    @DisplayName("Issue의 필드 값이 null이더라도 빈 리스트가 조회된다.")
    void persistencebag테스트() {
        // 영속화가 된, PersistentBag에 Assignees가 담긴 상태
        Issue issue = issueRepository.findAll().get(0);

        // 따라서 설사 null이더라도 빈 리스트가 조회
        Assertions.assertThat(issue.getAssignees().size()).isEqualTo(0);
    }

}
