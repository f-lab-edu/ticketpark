package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@RequiredArgsConstructor
public class MybatisTicketGradeRepository implements TicketGradeRepository{

    private final TicketGradeMapper ticketGradeMapper;

    @Override
    public void createTicketGrade(List<TicketGrade> ticketGradeList) {
        ticketGradeMapper.createTicketGrade(ticketGradeList);
    }

    @Override
    public Integer getCountTicketGrade(Long ticketGradeId) {
        return ticketGradeMapper.getCountTicketGrade(ticketGradeId);
    }

    @Override
    public Integer getCountTicketByGradeByPessimisticLock(Long ticketGradeId) {
        return ticketGradeMapper.getCountTicketByGradeByPessimisticLock(ticketGradeId);
    }

    @Override
    public TicketGrade getTicketGrade(Long ticketGradeId) {
        return ticketGradeMapper.getTicketGrade(ticketGradeId);
    }

    @Override
    public Integer updateSeatCountByByOptimisticLock(Long ticketGradeId, Long version) {
        return ticketGradeMapper.updateSeatCountByByOptimisticLock(ticketGradeId, version);
    }

    @Override
    public Integer updateSeatCount(Long ticketGradeId) {
        return ticketGradeMapper.updateSeatCount(ticketGradeId);
    }



    @Override
    public void deleteAllTicketGrade() {
        ticketGradeMapper.deleteAllTicketGrade();
    }
}
