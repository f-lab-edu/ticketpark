package com.ticketpark.ticket.model.entity;

import com.ticketpark.ticket.model.dto.TicketDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket {
    //pk
    private Long ticket_id;
    //티켓 예매 시작 시간
    private LocalDateTime start_dt;
    //티켓 예매 종료 시간
    private LocalDateTime end_dt;
    //티켓 생성 일시(이력용)
    private LocalDateTime created_dt;
    //performance 테이블 pk
    private Long performance_id;

    public static Ticket of(TicketDto dto){
        Ticket ticket = new Ticket();
        ticket.setStart_dt(dto.getStart_dt());
        ticket.setEnd_dt(dto.getEnd_dt());
        ticket.setCreated_dt(dto.getCreated_dt());
        ticket.setPerformance_id(dto.getPerformance_id());
        return ticket;
    }
}
