package com.team33.backend.emoji.service;

import lombok.Getter;

@Getter
public class EmotionCache {

    private final Long id;
    private final String emotion;

    public EmotionCache(Long id, String emotion) {
        this.id = id;
        this.emotion = emotion;
    }
}
