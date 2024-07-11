package com.ticketpark.ticket.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Ticket_order {
    private Long ticket_order_id;
    private Long member_id;
    private Long performance_id;
    private Long ticket_grade_id;
    private Timestamp created_dt;
}
