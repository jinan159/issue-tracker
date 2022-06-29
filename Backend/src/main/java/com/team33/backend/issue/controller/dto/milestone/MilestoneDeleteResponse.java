package com.team33.backend.issue.controller.dto.milestone;

import com.team33.backend.issue.domain.Milestone;
import lombok.Getter;

@Getter
public class MilestoneDeleteResponse {

    private final Long id;

    public MilestoneDeleteResponse(Milestone milestone) {
        this.id = milestone.getId();
    }
}
