package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.TicketOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface TicketOrderMapper {
    void createTicketOrder(@Param("ticketOrder") TicketOrder ticketOrder);
    Optional<TicketOrder> getTickOrderBySeatInfo(
             Long performanceId
            , Long ticketGradeId
            ,  String seatInfo);

    Optional<TicketOrder> getTickOrder(Long ticketOrderId);

}
