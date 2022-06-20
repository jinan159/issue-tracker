package com.team33.backend.comment.service;

import com.team33.backend.comment.Comment;
import com.team33.backend.comment.controller.CommentEditRequest;
import com.team33.backend.comment.controller.dto.CommentWriteRequest;
import com.team33.backend.issue.domain.Issue;
import com.team33.backend.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;

    @Transactional
    public Comment writeComment(String githubId, CommentWriteRequest request) {
        // 임시 예외처리
        Member findMember = memberRepository.findByGithubId(githubId).orElseThrow();
        Issue findIssue = issueRepository.findById(request.getIssueId()).orElseThrow();

        // 이미지는 일단 없다고 가정
        Comment newComment = new Comment(request.getContent(), null, findMember, findIssue);
        return commentRepository.save(newComment);
    }

    @Transactional
    public Comment editComment(CommentEditRequest request) {
        Comment findComment = commentRepository.findById(request.getId()).orElseThrow();
        findComment.editComment(request.getContent());
        return findComment;
    }

    @Transactional
    public Comment deleteComment(Long commentId) {
        Comment findComment = commentRepository.findById(commentId).orElseThrow();
        findComment.deleteComment();
        return null;
    }
}
