package com.team33.backend.comment;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
public class Deleted {

    private boolean deleted;

    public Deleted() {
        this.deleted = init();
    }

    private boolean init() {
        return false;
    }

    public void isTrue() {
        this.deleted = true;
    }

}
