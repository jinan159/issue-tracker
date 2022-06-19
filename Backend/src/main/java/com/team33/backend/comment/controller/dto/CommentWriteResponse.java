package com.team33.backend.comment.controller.dto;

import com.team33.backend.comment.Comment;
import lombok.Getter;

@Getter
public class CommentWriteResponse {

    private final Long id;
    private final String content;

    public CommentWriteResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }
}
