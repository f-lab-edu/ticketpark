package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TicketGradeRepository {
    void createTicketGrade(List<TicketGrade> ticketGradeList);

    int getCountTicketGrade(Long ticket_grade_id);

    int updateSeatCount(Long ticket_grade_id);
}
