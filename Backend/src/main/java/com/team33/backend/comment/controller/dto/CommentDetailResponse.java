package com.team33.backend.comment.controller.dto;

import com.team33.backend.emoji.controller.dto.cache.CommentCache;
import lombok.Getter;

@Getter
public class CommentDetailResponse {

    private Long id;

    public CommentDetailResponse(CommentCache commentCache) {
        this.id = commentCache.getId();
    }
}
