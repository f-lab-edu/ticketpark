package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import java.util.List;

public interface TicketGradeRepository {
    void createTicketGrade(List<TicketGrade> ticketGradeList);

    Integer getCountTicketGrade(Long ticket_grade_id);

    Integer updateSeatCount(Long ticket_grade_id);
}
