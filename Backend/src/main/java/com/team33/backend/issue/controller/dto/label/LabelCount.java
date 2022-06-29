package com.team33.backend.issue.controller.dto.label;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@AllArgsConstructor
public class LabelCount {

    private final long value;
}
