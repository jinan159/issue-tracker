package com.team33.backend.comment.controller;

import com.team33.backend.comment.Comment;
import lombok.Getter;

@Getter
public class CommentEdieResponse {

    private Long id;
    private String content;

    public CommentEdieResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }

    public CommentEdieResponse() {
    }
}
