package com.team33.backend.comment.controller.dto;

import lombok.Getter;

@Getter
public class CommentWriteRequest {

    private final Long issueId;
    private final String content;

    public CommentWriteRequest(Long issueId, String content) {
        this.issueId = issueId;
        this.content = content;
    }
}
