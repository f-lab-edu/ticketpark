package com.ticketpark.ticket.model.dto;

import com.ticketpark.performance.model.entity.Performance;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class TicketDto {
    //티켓 예매 시작 시간
    private LocalDateTime start_dt;
    //티켓 예매 종료 시간
    private LocalDateTime end_dt;
    //티켓 생성 시간(이력용)
    private LocalDateTime created_dt;
    //performance 테이블 pk
    private Long performance_id;

    //Performance pk와 연결
    public TicketDto connectPerformance(Long performanceId) {
        this.performance_id = performanceId;
        return this;
    }

    @Builder
    public TicketDto(LocalDateTime start_dt, LocalDateTime end_dt, LocalDateTime created_dt){
        this.start_dt = start_dt;
        this.end_dt = end_dt;
        this.created_dt = created_dt;
    }
}
