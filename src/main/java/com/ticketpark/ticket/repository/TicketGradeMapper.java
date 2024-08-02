package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TicketGradeMapper {
    void createTicketGrade(List<TicketGrade> ticketGradeList);
    Integer getCountTicketGrade(Long ticket_grade_id);
    Integer updateSeatCount(Long ticket_grade_id);
}
