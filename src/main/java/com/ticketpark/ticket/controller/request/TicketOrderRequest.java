package com.ticketpark.ticket.controller.request;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class TicketOrderRequest {
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String seat_info;

    public TicketOrderDto fromRequest(TicketOrderRequest request){
        return new TicketOrderDto(
                request.getMember_id()
                , request.getPerformance_id()
                , request.getTicket_grade_id()
                , request.getSeat_info()
                , LocalDateTime.now()
        );
    }
}
