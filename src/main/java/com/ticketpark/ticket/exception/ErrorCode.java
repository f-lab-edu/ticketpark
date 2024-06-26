package com.ticketpark.ticket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    DUPLICATED_ID(HttpStatus.CONFLICT,"이미 가입된 아이디입니다.");

    private final HttpStatus status;
    private final String message;
}
