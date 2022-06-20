package com.team33.backend.member.controller;

import com.team33.backend.member.controller.dto.MemberQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberQueryService memberQueryService;

    @GetMapping("{groupId}")
    public List<MemberQueryResponse> findIssueGroupMembers(@PathVariable Long groupId){
        return memberQueryService.findGroupMembers(groupId);
    }
}
