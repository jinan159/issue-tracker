package com.team33.backend.member.controller.dto;

import lombok.Getter;

@Getter
public class MemberQueryResponse {

    private final Long id;
    private final String name;

    public MemberQueryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
