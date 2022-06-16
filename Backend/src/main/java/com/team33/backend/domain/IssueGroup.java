package com.team33.backend.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class IssueGroup extends CommonEntity {

    @Id @Column(name = "member_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "issueGroup", cascade = CascadeType.REMOVE)
    private List<IssueGroupMember> issueGroupMembers = new ArrayList<>();
}
