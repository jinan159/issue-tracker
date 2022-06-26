package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import com.team33.backend.issue.domain.filter.Filter;
import com.team33.backend.issue.domain.filter.FilterStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterService {

    private static final List<FilterResponse> filterResponses = new ArrayList<>();

    private final FilterStrategy issueFilterStrategy;

    public List<FilterResponse> findAllFilters() {
        if (filterResponses.isEmpty()) {
            for (Filter filter : issueFilterStrategy.getFilters()) {
                filterResponses.add(new FilterResponse(filter.getFilter(), filter.getDescription()));
            }
        }

        return List.copyOf(filterResponses);
    }
}
