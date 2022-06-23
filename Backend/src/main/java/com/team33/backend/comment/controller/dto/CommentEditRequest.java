package com.team33.backend.comment.controller.dto;

import lombok.Getter;

@Getter
public class CommentEditRequest {

    private String content;

    public CommentEditRequest(String content) {
        this.content = content;
    }

    public CommentEditRequest() {
    }
}
