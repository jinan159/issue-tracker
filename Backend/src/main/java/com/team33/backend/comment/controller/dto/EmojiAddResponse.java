package com.team33.backend.comment.controller.dto;

import com.team33.backend.emoji.domain.Emoji;
import lombok.Getter;

@Getter
public class EmojiAddResponse {

    private final Long id;
    private final String emotion;

    public EmojiAddResponse(Emoji emoji) {
        this.id = emoji.getId();
        this.emotion = emoji.getEmotion();
    }
}
