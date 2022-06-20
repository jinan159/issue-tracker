package com.team33.backend.comment.service;

import com.team33.backend.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByGithubId(String githubId);
}
