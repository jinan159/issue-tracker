package com.team33.backend.member.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // for jackson
public class MembersFinedRequest {

    private Long groupId;
}
