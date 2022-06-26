package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.filter.FilterResponse;
import com.team33.backend.issue.domain.filter.Filter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FilterServiceTest {

    private FilterService filterService;

    private final List<Filter> FILTERS =  List.of(
            createNewFilter("is:test", "테스트입니다"),
            createNewFilter("commented:@me", "댓글단것"),
            createNewFilter("assigned:@me", "할당된것")
    );

    @BeforeEach
    void setUp() {
        filterService = new FilterService(() -> FILTERS);
    }

    @Test
    void 필터를_조회하면_필터_리스트가_반환된다() {
        // when
        List<FilterResponse> filterResponses = filterService.findAllFilters();

        // then
        assertThat(filterResponses).isNotNull();
        assertThat(filterResponses).isNotEmpty();
        assertThat(filterResponses).size().isEqualTo(FILTERS.size());
        for (int i = 0; i < filterResponses.size(); i++) {
            FilterResponse filterResponse = filterResponses.get(i);
            Filter expectedFilter = FILTERS.get(i);

            assertThat(filterResponse.getFilter()).isEqualTo(expectedFilter.getFilter());
            assertThat(filterResponse.getDescription()).isEqualTo(expectedFilter.getDescription());
        }
    }

    private Filter createNewFilter(String filter, String description) {
        return new Filter() {
            @Override
            public String getFilter() {
                return filter;
            }

            @Override
            public String getDescription() {
                return description;
            }
        };
    }
}