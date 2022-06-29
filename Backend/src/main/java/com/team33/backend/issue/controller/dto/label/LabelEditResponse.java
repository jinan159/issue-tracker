package com.team33.backend.issue.controller.dto.label;

import com.team33.backend.issue.domain.Label;
import lombok.Getter;

@Getter
public class LabelEditResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final String color;

    public LabelEditResponse(Label label) {
        this.id = label.getId();
        this.name = label.getName();
        this.description = label.getDescription();
        this.color = label.getColor();
    }
}
