package com.team33.backend.emoji.controller.dto.cache;

import com.team33.backend.emoji.domain.Emoji;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmojiCache {

    private Long id;
    private String emotion;
    private Long commentId;

    public EmojiCache(Emoji emoji) {
        this.id = emoji.getId();
        this.emotion = emoji.getEmotion();
    }

    public EmojiCache() {
    }

    @Override
    public String toString() {
        return "EmojiCache{" +
                "id=" + id +
                ", emotion='" + emotion + '\'' +
                ", commentId=" + commentId +
                '}';
    }
}
