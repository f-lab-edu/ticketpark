package com.ticketpark.ticket.controller.request;

import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TicketOrderRequest {
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String order_serial_num;
    private String seat_info;

    public TicketOrder getTicketOrderEntity(TicketOrderRequest request){
        TicketOrder ticketOrder = new TicketOrder();
        ticketOrder.setMember_id(request.getMember_id());
        ticketOrder.setPerformance_id(request.getPerformance_id());
        ticketOrder.setTicket_grade_id(request.getTicket_grade_id());
        ticketOrder.setOrder_serial_num(request.getOrder_serial_num());
        ticketOrder.setSeat_info(request.getSeat_info());
        ticketOrder.setCreated_dt(LocalDateTime.now());
        return ticketOrder;
    }
}
