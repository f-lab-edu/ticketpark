package com.ticketpark.ticket.model.dto;

import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class TicketOrderDto {
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String seat_info;
    private LocalDateTime created_dt;

    public TicketOrder getEntity(){
        return TicketOrder.builder()
                .member_id(this.getMember_id())
                .performance_id(this.getPerformance_id())
                .ticket_grade_id(this.getTicket_grade_id())
                .seat_info(this.getSeat_info())
                .created_dt(LocalDateTime.now())
                .build();
    }
}
