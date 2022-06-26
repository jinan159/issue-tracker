package com.team33.backend.issue.controller;

import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import com.team33.backend.issue.service.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FilterController {

    private final FilterService filterService;

    @GetMapping("/filters")
    public List<FilterResponse> filterList() {
        return filterService.findAllFilters();
    }
}
