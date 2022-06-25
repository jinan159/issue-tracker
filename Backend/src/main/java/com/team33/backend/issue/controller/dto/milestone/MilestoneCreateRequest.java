package com.team33.backend.issue.controller.dto.milestone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor // for jackson
public class MilestoneCreateRequest {

    private String title;
    private LocalDate deadline;
    private String description;
}
