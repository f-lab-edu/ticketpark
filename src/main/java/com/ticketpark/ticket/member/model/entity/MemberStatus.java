package com.ticketpark.ticket.member.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatus {
    USE('Y'),
    NON_USE('N');

    private final char status;
}
