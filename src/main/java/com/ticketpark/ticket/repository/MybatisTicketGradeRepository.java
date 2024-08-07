package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisTicketGradeRepository implements TicketGradeRepository{

    private final TicketGradeMapper ticketGradeMapper;

    @Override
    public void createTicketGrade(List<TicketGrade> ticketGradeList) {
        ticketGradeMapper.createTicketGrade(ticketGradeList);
    }
}
