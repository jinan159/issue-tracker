package com.team33.backend.comment.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor // for jackson
public class CommentWriteRequest {

    @NotBlank
    private String content;
}
