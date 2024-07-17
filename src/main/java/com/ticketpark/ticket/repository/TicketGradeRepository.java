package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.Ticket_grade;

import java.util.List;

public interface TicketGradeRepository {
    void createTicketGrade(List<Ticket_grade> ticketGradeList);
}
