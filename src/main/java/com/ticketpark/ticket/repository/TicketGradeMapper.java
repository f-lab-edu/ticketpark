package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketGradeMapper {
    void createTicketGrade(List<TicketGrade> ticketGradeList);
    int getCountTicketGrade(@Param("ticket_grade_id") Long ticket_grade_id);
    int updateSeatCount(@Param("ticket_grade_ids") Long ticket_grade_id);
}
