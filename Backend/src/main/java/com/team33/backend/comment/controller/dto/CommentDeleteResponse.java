package com.team33.backend.comment.controller.dto;

import com.team33.backend.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentDeleteResponse {

    private final Long id;

    public CommentDeleteResponse(Comment comment) {
        this.id = comment.getId();
    }
}
