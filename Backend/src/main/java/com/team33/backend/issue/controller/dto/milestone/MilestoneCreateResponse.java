package com.team33.backend.issue.controller.dto.milestone;

import com.team33.backend.issue.domain.Milestone;
import lombok.Getter;

@Getter
public class MilestoneCreateResponse {

    private final Long id;
    private final String title;

    public MilestoneCreateResponse(Milestone milestone) {
        this.id = milestone.getId();
        this.title = milestone.getTitle();
    }
}
