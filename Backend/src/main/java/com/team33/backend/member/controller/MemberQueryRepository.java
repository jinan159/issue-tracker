package com.team33.backend.member.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team33.backend.member.controller.dto.MemberQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    // 보류
    public List<MemberQueryResponse> findGroupMembersById(Long groupId) {
        return null;
    }
}
