package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.Ticket_grade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisTicketGradeRepository implements TicketGradeRepository{

    private final TicketGradeMapper ticketGradeMapper;

    @Override
    public void createTicketGrade(List<Ticket_grade> ticketGradeList) {
        ticketGradeMapper.createTicketGrade(ticketGradeList);
    }
}
