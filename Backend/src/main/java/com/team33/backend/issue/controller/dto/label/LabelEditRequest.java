package com.team33.backend.issue.controller.dto.label;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // for jackson
public class LabelEditRequest {

    private String name;
    private String description;
    private String color;
}
