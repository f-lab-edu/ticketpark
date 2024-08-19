package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
@RequiredArgsConstructor
public class MyBatisTicketOrderRepository implements TicketOrderRepository {

    private final TicketOrderMapper ticketOrderMapper;

    @Override
    public void createTicketOrder(TicketOrder ticketOrder) {
        ticketOrderMapper.createTicketOrder(ticketOrder);
    }

    @Override
    public Optional<TicketOrder> getTickOrderBySeatInfo(Long performanceId, Long ticketGradeId, String seatInfo) {
        return ticketOrderMapper.getTickOrderBySeatInfo(performanceId, ticketGradeId, seatInfo);
    }

    @Override
    public Optional<TicketOrder> getTickOrderBySeatInfoAndPessimisticLock(Long performanceId, Long ticketGradeId, String seatInfo) {
        return ticketOrderMapper.getTickOrderBySeatInfoAndPessimisticLock(performanceId, ticketGradeId, seatInfo);
    }

    @Override
    public Optional<TicketOrder> getTickOrder(Long ticketOrderId) {
        return ticketOrderMapper.getTickOrder(ticketOrderId);
    }

    @Override
    public void deleteAllTicketOrder() {
        ticketOrderMapper.deleteAllTicketOrder();
    }


}
