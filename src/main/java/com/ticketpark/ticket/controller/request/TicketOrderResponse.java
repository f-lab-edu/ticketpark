package com.ticketpark.ticket.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class TicketOrderResponse {
    private Long ticket_order_id;
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String order_serial_num;
    private String seat_info;
}
