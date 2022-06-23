package com.team33.backend.comment.controller.dto;

import lombok.Getter;

@Getter
public class EmojiAddRequest {
    private final String emotion;

    public EmojiAddRequest(String emotion) {
        this.emotion = emotion;
    }
}
