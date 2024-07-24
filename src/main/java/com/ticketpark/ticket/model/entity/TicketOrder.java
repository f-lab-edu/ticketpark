package com.ticketpark.ticket.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class TicketOrder {
    private Long ticket_order_id;
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private String order_serial_num;
    private String seat_info;
    private LocalDateTime created_dt;
}
