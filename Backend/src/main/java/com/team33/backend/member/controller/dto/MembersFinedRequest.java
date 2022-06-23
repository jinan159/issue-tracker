package com.team33.backend.member.controller.dto;

import lombok.Getter;

@Getter
public class MembersFinedRequest {

    private Long groupId;

    public MembersFinedRequest(Long groupId) {
        this.groupId = groupId;
    }

    public MembersFinedRequest() {
    }
}
