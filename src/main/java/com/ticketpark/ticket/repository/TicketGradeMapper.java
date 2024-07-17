package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.Ticket_grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TicketGradeMapper {
    void createTicketGrade(List<Ticket_grade> ticketGradeList);
}
