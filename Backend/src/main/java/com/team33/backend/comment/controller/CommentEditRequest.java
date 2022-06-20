package com.team33.backend.comment.controller;

import lombok.Getter;

@Getter
public class CommentEditRequest {

    private Long id;
    private String content;

    public CommentEditRequest(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public CommentEditRequest() {
    }
}
