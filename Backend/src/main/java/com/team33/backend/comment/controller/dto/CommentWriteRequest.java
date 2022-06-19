package com.team33.backend.comment.controller.dto;

import lombok.Getter;

@Getter
public class CommentWriteRequest {

    private final String content;

    public CommentWriteRequest(String content) {
        this.content = content;
    }
}
