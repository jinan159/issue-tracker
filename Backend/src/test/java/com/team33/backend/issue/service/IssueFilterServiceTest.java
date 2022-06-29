package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.FilterListResponse;
import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import com.team33.backend.issue.domain.filter.IssueFilter;
import com.team33.backend.issue.domain.filter.IssueFilterStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IssueFilterServiceTest {

    private IssueFilterStrategy issueFilterStrategy = new IssueFilterStrategy();
    private IssueFilterService issueFilterService = new IssueFilterService(issueFilterStrategy);;

    @Test
    void 필터를_조회하면_필터_리스트가_반환된다() {
        // given
        List<IssueFilter> issueFilters = issueFilterStrategy.getFilters();

        // when
        FilterListResponse responses = issueFilterService.findAllFilters();

        // then
        assertThat(responses).isNotNull();

        List<FilterResponse> filters = responses.getFilters();
        assertThat(filters).isNotNull();
        assertThat(filters).isNotEmpty();
        assertThat(filters).size().isEqualTo(issueFilters.size());

        for (int i = 0; i < filters.size(); i++) {
            FilterResponse filterResponse = filters.get(i);
            IssueFilter expectedFilter = issueFilters.get(i);

            assertThat(filterResponse.getFilter()).isEqualTo(expectedFilter.getFilter());
            assertThat(filterResponse.getDescription()).isEqualTo(expectedFilter.getDescription());
        }
    }

    @Test
    void 열린이슈의_필터_문자열으로_필터를_조회하면_열린이슈_필터가_조회된다() {
        // given
        IssueFilter expectedIssueFilter = IssueFilter.OPEN;
        String openIssueFilter = expectedIssueFilter.getFilter();
        int expectedSize = 1;

        // when
        List<IssueFilter> filters = issueFilterService.findAllMatchedFilters(openIssueFilter);

        // then
        assertThat(filters).isNotNull();
        assertThat(filters).size().isEqualTo(expectedSize);
        assertThat(filters.get(0)).isEqualTo(expectedIssueFilter);
    }
}