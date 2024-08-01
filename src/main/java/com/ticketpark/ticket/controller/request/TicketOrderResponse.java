package com.ticketpark.ticket.controller.request;

import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class TicketOrderResponse {
    private Long ticket_order_id;
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String seat_info;

    public static TicketOrderResponse fromTicketOrder(TicketOrder ticketOrder) {
        return TicketOrderResponse.builder()
                .ticket_order_id(ticketOrder.getTicket_order_id())
                .member_id(ticketOrder.getMember_id())
                .performance_id(ticketOrder.getPerformance_id())
                .ticket_grade_id(ticketOrder.getTicket_grade_id())
                .seat_info(ticketOrder.getSeat_info())
                .build();
    }
}
