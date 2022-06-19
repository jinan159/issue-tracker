package com.team33.backend.comment;

import com.team33.backend.common.CommonEntity;
import com.team33.backend.emoji.Emoji;
import com.team33.backend.image.Image;
import com.team33.backend.issue.domain.Issue;
import com.team33.backend.member.Member;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
public class Comment extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotBlank
    private String content;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<Image> images = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id", nullable = false)
    private Issue issue;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.REMOVE)
    private List<Emoji> emojis = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment entity = (Comment) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
