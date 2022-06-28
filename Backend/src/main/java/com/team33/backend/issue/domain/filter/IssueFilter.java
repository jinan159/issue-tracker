package com.team33.backend.issue.domain.filter;

import com.team33.backend.common.exception.issue.FilterParseException;
import lombok.Getter;

@Getter
public enum IssueFilter {
    OPEN("is:open", "열린 이슈"),
    CLOSED("is:closed", "닫힌 이슈"),
    AUTHOR_ME("author:@me", "내가 작성한 이슈"),
    ASSIGNED_ME("assigned:@me", "나에게 할당된 이슈"),
    COMMENTED_ME("commented:@me", "내가 댓글을 남긴 이슈")
    ;

    private final String description;
    private final String filter;

    IssueFilter(String filter, String description) {
        this.filter = filter;
        this.description = description;
    }

    /**
     * @throws FilterParseException 해당하는 필터가 없을 경우 예외가 발생합니다.
     */
    public static IssueFilter parse(String filterKeyValue) {
        for (IssueFilter filter : values()) {
            if (filter.getFilter().equals(filterKeyValue)) return filter;
        }

        throw new FilterParseException();
    }
}
