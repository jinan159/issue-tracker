package com.team33.backend.issue.service;

import com.team33.backend.issue.controller.dto.MilestomeEditRequest;
import com.team33.backend.issue.controller.dto.MilestoneCount;
import com.team33.backend.issue.controller.dto.MilestoneCreateRequest;
import com.team33.backend.issue.domain.Milestone;
import com.team33.backend.issue.repository.query.MilestoneQueryRepository;
import com.team33.backend.issue.repository.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final MilestoneQueryRepository milestoneQueryRepository;

    @Transactional
    public Milestone createMilestone(MilestoneCreateRequest request) {
        Milestone newMilestone = new Milestone(request.getTitle(), request.getDescription(), request.getDeadline());
        return milestoneRepository.save(newMilestone);
    }

    @Transactional
    public Milestone editMilestone(Long milestoneId, MilestomeEditRequest request) {
        Milestone findMilestone = milestoneRepository.findById(milestoneId).orElseThrow();
        findMilestone.editMilestone(request.getTitle(), request.getDescription(), request.getLocalDate());
        return findMilestone;
    }

    @Transactional
    public MilestoneCount getIssueMilestoneCount(Long milestoneId) {
        return milestoneQueryRepository.countIssueMilestoneCount(milestoneId);
    }

    @Transactional
    public Milestone deleteMilestoneById(Long milestoneId) {
        Milestone findMilestone = milestoneRepository.findById(milestoneId).orElseThrow();
        milestoneRepository.delete(findMilestone);
        return findMilestone;
    }
}
