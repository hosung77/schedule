package com.example.schedulee.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 이메일
    INVALID_EMAIL(HttpStatus.BAD_REQUEST, "잘못된 이메일 형식입니다."),

    // 사용자
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"유저를 찾을 수 없습니다."),
    OVER_LIMITED_SIZE(HttpStatus.BAD_REQUEST,"Todo는 최대 200자까지 작성가능합니다."),
    INVALID_ID(HttpStatus.BAD_REQUEST, "잘못된 이메일 형식입니다."),


    // 비밀번호
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호는 8~20자, 영문 대소문자 중 하나와 숫자를 포함해야 합니다."),
    PASSWORD_NOT_MATCH(HttpStatus.FORBIDDEN,"비밀번호가 일치하지 않습니다."),

    // 스케줄
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND,"일치하는 스케줄이 없습니다.");

    private final HttpStatus status;
    private final String message;
}