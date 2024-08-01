package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisTicketOrderRepository implements TicketOrderRepository {

    private final TicketOrderMapper ticketOrderMapper;

    @Override
    public void createTicketOrder(TicketOrder ticketOrder) {
        ticketOrderMapper.createTicketOrder(ticketOrder);
    }

    @Override
    public Optional<TicketOrder> getTickOrderBySeatInfo(Long performance_id, Long ticket_grade_id, String seat_info) {
        return ticketOrderMapper.getTickOrderBySeatInfo(performance_id, ticket_grade_id, seat_info);
    }
}
