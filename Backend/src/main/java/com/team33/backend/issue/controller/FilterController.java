package com.team33.backend.issue.controller;

import com.team33.backend.issue.controller.dto.FilterListResponse;
import com.team33.backend.issue.service.IssueFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FilterController {

    private final IssueFilterService issueFilterService;

    @GetMapping("/filters")
    public FilterListResponse filterList() {
        return issueFilterService.findAllFilters();
    }
}
