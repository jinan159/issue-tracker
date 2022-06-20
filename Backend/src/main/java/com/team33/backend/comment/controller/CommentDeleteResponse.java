package com.team33.backend.comment.controller;

import com.team33.backend.comment.Comment;
import lombok.Getter;

@Getter
public class CommentDeleteResponse {

    private Long id;

    public CommentDeleteResponse(Comment comment) {
        this.id = comment.getId();
    }

    public CommentDeleteResponse() {
    }
}
