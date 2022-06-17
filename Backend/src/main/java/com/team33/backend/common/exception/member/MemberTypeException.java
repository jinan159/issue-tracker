package com.team33.backend.common.exception.member;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MemberTypeException {

    MEMBER_NOT_FOUND_EXCEPTION(404, "해당 유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    MemberTypeException(int errorCode, String message, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
