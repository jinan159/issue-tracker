package com.team33.backend.emoji.controller.dto.cache;

import com.team33.backend.emoji.controller.dto.cache.EmojiCache;
import lombok.Getter;
import lombok.Setter;

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

    public void registEmojis(List<EmojiCache> emojis){
        this.emojiCaches = convertEmojis(emojis);
    }

    private Set<EmojiCache> convertEmojis(List<EmojiCache> emojis) {
        return new HashSet<>(emojis);
    }
}
