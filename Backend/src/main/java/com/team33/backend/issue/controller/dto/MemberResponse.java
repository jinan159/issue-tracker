package com.team33.backend.issue.controller.dto;

import com.team33.backend.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private long id;
    private String name;
    private String profileImageUrl;

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getProfileImageUrl()
        );
    }
}
