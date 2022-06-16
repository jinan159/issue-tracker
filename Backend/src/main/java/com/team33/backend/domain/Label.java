package com.team33.backend.domain;

import javax.persistence.*;

@Entity
public class Label {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String description;

    @Column(length = 6)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;
}
