package com.team33.backend.domain;

import javax.persistence.*;

@Entity
public class Assignee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_ie")
    private Issue issue;
}
