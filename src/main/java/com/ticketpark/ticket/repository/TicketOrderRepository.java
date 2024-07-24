package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface TicketOrderRepository {
    void createTicketOrder(TicketOrder ticketOrder);
    Optional<TicketOrder> getTickOrderBySeatInfo(Long performance_id, Long ticket_grade_id, String seat_info);
}
