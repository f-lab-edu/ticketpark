package com.ticketpark.ticket.controller.request;

import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketOrderResponse {
    private Long ticketOrderId;
    private Long memberId;
    private Long performanceId;
    private Long ticketGradeId;
    private String seatInfo;

    public static TicketOrderResponse fromTicketOrder(TicketOrder ticketOrder) {
        return new TicketOrderResponse(
                ticketOrder.getTicket_order_id()
                , ticketOrder.getMember_id()
                , ticketOrder.getPerformance_id()
                , ticketOrder.getTicket_grade_id()
                , ticketOrder.getSeat_info()
        );
    }
}
