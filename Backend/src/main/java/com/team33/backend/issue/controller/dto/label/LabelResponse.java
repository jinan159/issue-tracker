package com.team33.backend.issue.controller.dto.label;

import com.team33.backend.issue.domain.Label;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LabelResponse {

    private long id;
    private String name;
    private String color;

    public static LabelResponse from(Label label) {
        return new LabelResponse(
                label.getId(),
                label.getName(),
                label.getColor()
        );
    }
}
