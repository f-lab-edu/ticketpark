package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketOrder;
import java.util.Optional;

public interface TicketOrderRepository {
    void createTicketOrder(TicketOrder ticketOrder);
    Optional<TicketOrder> getTickOrderBySeatInfo(Long performanceId, Long ticketGradeId, String seatInfo);
    Optional<TicketOrder> getTickOrderBySeatInfoAndPessimisticLock(Long performanceId, Long ticketGradeId, String seatInfo);

    Optional<TicketOrder> getTickOrder(Long ticketOrderId);
    void deleteAllTicketOrder();
}
