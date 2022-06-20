package com.team33.backend.comment.controller;

import com.team33.backend.comment.controller.dto.CommentWriteRequest;
import com.team33.backend.comment.controller.dto.CommentWriteResponse;
import com.team33.backend.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping
    public CommentEdieResponse edieComment(@RequestBody CommentEditRequest request){
        return new CommentEdieResponse(commentService.editComment(request));
    }

    @DeleteMapping("{commentId}")
    public CommentDeleteResponse deleteComment(@PathVariable Long commentId){
        return new CommentDeleteResponse(commentService.deleteComment(commentId));
    }
}
