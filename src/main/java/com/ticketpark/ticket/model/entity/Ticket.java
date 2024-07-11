package com.ticketpark.ticket.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Ticket {
    private Long ticket_id;
    private Timestamp start_dt;
    private Timestamp end_dt;
    private Timestamp created_dt;
    private Long performance_id;
}
