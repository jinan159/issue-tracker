package com.team33.backend.comment.controller;

import com.team33.backend.comment.controller.dto.CommentWriteRequest;
import com.team33.backend.comment.controller.dto.CommentWriteResponse;
import com.team33.backend.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentWriteResponse writeComment(HttpServletRequest servletRequest,  @RequestBody CommentWriteRequest request){
        String memberId = (String) servletRequest.getAttribute("memberId");
        return new CommentWriteResponse(commentService.writeComment(memberId, request));
    }
}
