package com.team33.backend.issue.controller;

import com.team33.backend.issue.controller.dto.label.LabelDeleteResponse;
import com.team33.backend.issue.controller.dto.label.LabelEditRequest;
import com.team33.backend.issue.controller.dto.label.LabelEditResponse;
import com.team33.backend.issue.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/issuegroup")
public class LabelController {

    private final LabelService labelService;

    @PutMapping("/{issueGroupId}/labels/{labelId}")
    public LabelEditResponse editLabel(@PathVariable Long issueGroupId, @PathVariable Long labelId,
                                       @RequestBody LabelEditRequest request){
        return new LabelEditResponse(labelService.editLabel(labelId, request));
    }

    @DeleteMapping("/{issueGroupId}/labels/{labelId}")
    public LabelDeleteResponse editLabel(@PathVariable Long issueGroupId, @PathVariable Long labelId){
        return new LabelDeleteResponse(labelService.deleteLabelById(labelId));
    }
}
