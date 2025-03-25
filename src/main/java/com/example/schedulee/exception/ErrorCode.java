package com.example.schedulee.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 사용자
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"유저를 찾을 수 없습니다."),
    INVALID_ID(HttpStatus.BAD_REQUEST, "Id값이 null 입니다."),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지 않습니다."),

    // 스케줄
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND,"일치하는 스케줄이 없습니다.");

    private final HttpStatus status;
    private final String message;
}