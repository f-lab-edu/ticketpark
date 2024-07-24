package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface TicketOrderMapper {
    void createTicketOrder(@Param("ticketOrder") TicketOrder ticketOrder);
    Optional<TicketOrder> getTickOrderBySeatInfo(
            @Param("performance_id") Long performance_id
            , @Param("ticket_grade_id")Long ticket_grade_id
            , @Param("seat_info") String seat_info);
}
