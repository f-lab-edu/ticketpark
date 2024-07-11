package com.ticketpark.ticket.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Ticket_grade {
    private Long ticket_grade_id;
    private String grade;
    private String grade_name;
    private Integer seat_count;
    private Integer price;
    private Timestamp created_dt;
    private Long ticket_id;
}
