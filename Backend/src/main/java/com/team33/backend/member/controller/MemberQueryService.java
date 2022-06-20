package com.team33.backend.member.controller;

import com.team33.backend.member.controller.dto.MemberQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberQueryRepository memberQueryRepository;

    @Transactional(readOnly = true)
    public List<MemberQueryResponse> findGroupMembers(Long groupId) {
        return memberQueryRepository.findGroupMembersById(groupId);
    }
}
