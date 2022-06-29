package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.FilterListResponse;
import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import com.team33.backend.issue.controller.dto.issue.IssueListRequest;
import com.team33.backend.issue.domain.filter.IssueFilter;
import com.team33.backend.issue.domain.filter.IssueFilterStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueFilterService {

    private static final List<FilterResponse> filterResponses = new ArrayList<>();

    private final IssueFilterStrategy issueFilterStrategy;

    public FilterListResponse findAllFilters() {
        if (filterResponses.isEmpty()) {
            for (IssueFilter filter : issueFilterStrategy.getFilters()) {
                filterResponses.add(new FilterResponse(filter.getFilter(), filter.getDescription()));
            }
        }

        return new FilterListResponse(List.copyOf(filterResponses), issueFilterStrategy.getSeparator());
    }

    public List<IssueFilter> findAllMatchedFilters(String filterQuery) {
        return issueFilterStrategy.findMatchedIssueFilters(filterQuery);
    }
}
