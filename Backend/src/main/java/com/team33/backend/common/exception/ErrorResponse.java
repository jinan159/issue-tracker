package com.team33.backend.common.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Issue, Label, MileStone, Member, Comment
 * */
@Getter
public class ErrorResponse {

    private int code;
    private String message;
    private HttpStatus httpStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime time;

    public ErrorResponse(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = LocalDateTime.now();
    }

    public static ErrorResponse create(BaseExceptionType baseExceptionType) {
        return new ErrorResponse(baseExceptionType.getErrorCode(), baseExceptionType.getErrorMessage(), baseExceptionType.getHttpStatus());
    }
}
