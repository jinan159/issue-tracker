package com.team33.backend.issue.controller.dto.milestone;

import lombok.Getter;

@Getter
public class MilestoneCount {

    private final long count;

    public MilestoneCount(long count) {
        this.count = count;
    }
}
