package com.team33.backend.comment.service;

import com.team33.backend.emoji.controller.dto.cache.CommentCache;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CommentCaches {

    private static final String COMMENT = "COMMENT#";
    private final Map<Long, String> convertMap = new ConcurrentHashMap<>();
    private final Map<String, List<CommentCache>> commentCaches = new ConcurrentHashMap<>();

    private String createKey(Long id) {
        return COMMENT + id;
    }

    public List<CommentCache> getCommentCaches(Long issueId) {
        return new ArrayList<>(commentCaches.get(convertMap.get(issueId)));
    }
}
