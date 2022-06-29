package com.team33.backend.issue.repository;

import com.team33.backend.issue.domain.Issue;
import com.team33.backend.issue.domain.IssueStatus;
import com.team33.backend.issuegroup.domain.IssueGroup;
import com.team33.backend.issuegroup.repository.IssueGroupRepository;
import com.team33.backend.member.domain.Member;
import com.team33.backend.member.repository.MemberRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IssueRepositoryUtils {

    private final MemberRepository memberRepository;
    private final IssueGroupRepository issueGroupRepository;
    private final IssueRepository issueRepository;

    public Member saveNewMember() {
        int postFix = memberRepository.findAll().size();
        return memberRepository.save(new Member("newMember_" + postFix, "githubId_" + postFix, "https://profile.image.url"));
    }
    public IssueGroup saveNewIssueGroup() {
        int postFix = issueGroupRepository.findAll().size();
        return issueGroupRepository.save(new IssueGroup("default_" + postFix));
    }

    public Issue saveNewIssue(IssueStatus issueStatus) {
        return saveNewIssue(saveNewMember(), saveNewIssueGroup(), issueStatus);
    }

    public Issue saveNewIssue(IssueGroup issueGroup, IssueStatus issueStatus) {
        return saveNewIssue(saveNewMember(), issueGroup, issueStatus);
    }

    public Issue saveNewIssue(Member member, IssueGroup issueGroup, IssueStatus issueStatus) {
        Issue issue = new Issue("안녕하세요", member, issueGroup);

        if (IssueStatus.CLOSED.equals(issueStatus)) {
            issue.close();
        }

        return issueRepository.save(issue);
    }
}
