package com.ticketpark.ticket.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TicketParkHttpStatus {

    RESOURCE_CONFLICT(409, "resource conflict");
    private final int httpCode;
    private final String reasonPhrase;
}