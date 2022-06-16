package com.team33.backend.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Label {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank
    private String name;

    @Column(length = 100)
    private String description;

    @Column(length = 6, columnDefinition = "char(6)")
    @NotBlank
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;
}
