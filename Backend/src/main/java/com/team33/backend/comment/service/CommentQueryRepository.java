package com.team33.backend.comment.service;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team33.backend.emoji.controller.dto.cache.CommentCache;
import com.team33.backend.emoji.controller.dto.cache.EmojiCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.team33.backend.comment.domain.QComment.comment;
import static com.team33.backend.emoji.domain.QEmoji.emoji;

@Repository
@RequiredArgsConstructor
public class CommentQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<CommentCache> findCommentsByIssueId(Long issueId) {
        return queryFactory.select(
                        Projections.fields(CommentCache.class, comment.id, comment.content))
                .from(comment)
                .where(comment.issue.id.eq(issueId))
                .fetch();
    }

    public List<EmojiCache> findEmojisByCommentId(List<Long> commentIds) {
        return queryFactory.select(Projections.fields(EmojiCache.class,
                        emoji.id, emoji.emotion, emoji.comment.id.as("commentId")))
                .from(emoji)
                .where(emoji.comment.id.in(commentIds))
                .fetch();
    }
}
