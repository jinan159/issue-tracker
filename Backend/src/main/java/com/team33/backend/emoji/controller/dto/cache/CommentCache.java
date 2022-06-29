package com.team33.backend.emoji.controller.dto.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class CommentCache implements Serializable {

    private Long id;
    private String content;
    private Set<EmojiCache> emojiCaches;

    public CommentCache() {
    }

    public CommentCache(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void registEmojis(List<EmojiCache> emojis){
        this.emojiCaches = convertEmojis(emojis);
    }

    private Set<EmojiCache> convertEmojis(List<EmojiCache> emojis) {
        return new HashSet<>(emojis);
    }
}
