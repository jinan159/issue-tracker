package com.team33.backend.issue.controller.dto.milestone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // for jackson
public class MilestoneTitleEditRequest {

    private String title;
}
