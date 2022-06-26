package com.team33.backend.issue.domain.filter;

import com.team33.backend.common.exception.issue.FilterParseException;

public enum IssueFilter implements Filter {
    OPEN("열린 이슈", Key.IS, Value.OPEN),
    CLOSED("닫힌 이슈", Key.IS, Value.CLOSED),
    AUTHOR("내가 작성한 이슈", Key.AUTHOR, Value.ME),
    ASSIGNED("나에게 할당된 이슈", Key.ASSIGNED, Value.ME),
    COMMENTED("내가 댓글을 남긴 이슈", Key.COMMENTED, Value.ME)
    ;

    private static final String SEPARATOR = ":";

    private final String description;
    private final Key key;
    private final Value value;

    IssueFilter(String description, Key key, Value value) {
        this.description = description;
        this.key = key;
        this.value = value;
    }

    /**
     * @throws FilterParseException
     */
    public static IssueFilter parse(String filterText) {
        if (!filterText.contains(SEPARATOR)) throw new FilterParseException();

        try {
            String[] split = filterText.split(SEPARATOR);

            String key = split[0];
            String value = split[1];

            for (IssueFilter filter : values()) {
                if (filter.key.equals(key) && filter.value.equals(value)) return filter;
            }
        } catch (Exception e) {
            throw new FilterParseException(e);
        }

        throw new FilterParseException();
    }

    @Override
    public String getFilter() {
        return this.key.text + SEPARATOR + this.value.text ;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    // key 상수들을 관리하는 enum 클래스
    private enum Key {
        IS("is"),
        AUTHOR("author"),
        ASSIGNED("assigned"),
        COMMENTED("commented"),
        ;

        private String text;

        Key(String text) {
            this.text = text;
        }
    }

    // value 상수들을 관리하는 enum 클래스
    private enum Value {
        OPEN("open"),
        CLOSED("closed"),
        ME("@me")
        ;

        private String text;

        Value(String text) {
            this.text = text;
        }
    }
}
