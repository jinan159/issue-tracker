package com.team33.backend.comment.controller.dto;

import com.team33.backend.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentEditResponse {

    private final Long id;
    private final String content;

    public CommentEditResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }
}
