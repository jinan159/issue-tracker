package com.team33.backend.comment.domain;

import com.team33.backend.common.CommonEntity;
import com.team33.backend.emoji.domain.Emoji;
import com.team33.backend.image.Image;
import com.team33.backend.issue.domain.Issue;
import com.team33.backend.member.domain.Member;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @Embedded
    private Deleted deleted;

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

    public Comment(String content, List<Image> images, Member member, Issue issue) {
        this.content = content;
        this.images = images;
        this.member = member;
        this.issue = issue;
    }

    protected Comment() {
    }

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

    public void editComment(String content) {
        this.content = content;
    }

    public void deleteComment() {
        deleted.isTrue();
    }
}
