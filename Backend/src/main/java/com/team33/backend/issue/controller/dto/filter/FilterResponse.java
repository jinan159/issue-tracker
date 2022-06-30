package com.team33.backend.issue.controller.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilterResponse {

    private String filter;
    private String description;
}
