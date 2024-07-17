package com.ticketpark.ticket.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TicketDto {
    //티켓 예매 시작 시간
    private LocalDateTime start_dt;
    //티켓 예매 종료 시간
    private LocalDateTime end_dt;
    //티켓 생성 시간(이력용)
    private LocalDateTime created_dt;
    //performance 테이블 pk
    private Long performance_id;
}
