package com.team33.backend.issue.controller.dto;

import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FilterListResponse {

    private final List<FilterResponse> filters;
    private final String separator;
}
