package com.ticketpark.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    DUPLICATE_ID(TicketParkHttpStatus.RESOURCE_CONFLICT,"이미 가입된 아이디입니다.");
    private final TicketParkHttpStatus status;
    private final String message;
}
