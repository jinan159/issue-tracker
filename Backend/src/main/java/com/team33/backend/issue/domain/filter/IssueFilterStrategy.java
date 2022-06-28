package com.team33.backend.issue.domain.filter;

import com.team33.backend.common.exception.issue.FilterParseException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueFilterStrategy {

    private static final String SEPARATOR = "\\+";

    private static final List<IssueFilter> issueFilters = new ArrayList<>();

    public List<IssueFilter> getFilters() {
        if (issueFilters.isEmpty()) {
            issueFilters.addAll(getIssueFilters());
        }

        return List.copyOf(issueFilters);
    }

    private List<IssueFilter> getIssueFilters() {
        return Arrays.stream(IssueFilter.values())
                .collect(Collectors.toList());
    }

    public String getSeparator() {
        return SEPARATOR;
    }

    public List<IssueFilter> findMatchedIssueFilters(String filterQuery) {
        String[] filters = filterQuery.split(SEPARATOR);

        return getMatchedFilters(filters);
    }

    private List<IssueFilter> getMatchedFilters(String[] filters) {
        List<IssueFilter> matchedIssueFilters = new ArrayList<>();

        for (String filter : filters) {
            try {
                matchedIssueFilters.add(IssueFilter.parse(filter));
            } catch (FilterParseException e) { }
        }

        return matchedIssueFilters;
    }
}
