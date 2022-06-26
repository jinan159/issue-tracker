package com.team33.backend.issue.domain.filter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueFilterStrategy implements FilterStrategy {

    private static final List<Filter> issueFilters = new ArrayList<>();

    @Override
    public List<Filter> getFilters() {
        if (issueFilters.isEmpty()) {
            issueFilters.addAll(getIssueFilters());
        }

        return List.copyOf(issueFilters);
    }

    private List<IssueFilter> getIssueFilters() {
        return Arrays.stream(IssueFilter.values())
                .collect(Collectors.toList());
    }
}
