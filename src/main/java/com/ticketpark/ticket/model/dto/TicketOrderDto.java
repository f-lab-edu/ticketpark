package com.ticketpark.ticket.model.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TicketOrderDto {

    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String order_serial_num;
    private String seat_info;
    private LocalDateTime created_dt;
}
