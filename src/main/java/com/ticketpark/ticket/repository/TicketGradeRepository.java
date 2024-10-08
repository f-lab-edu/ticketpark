package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketGrade;
import java.util.List;

public interface TicketGradeRepository {
    void createTicketGrade(List<TicketGrade> ticketGradeList);

    Integer getCountTicketGrade(Long ticketGradeId);

    Integer getCountTicketByGradeByPessimisticLock(Long ticketGradeId);

    TicketGrade getTicketGrade(Long ticketGradeId);

    Integer updateSeatCount(Long ticketGradeId);

    Integer updateSeatCountByByOptimisticLock(Long ticketGradeId, Long version);

    void deleteAllTicketGrade();
}
