package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TicketMapper {
    void createTicket(@Param("ticket") Ticket ticket);
    void deleteAllTicket();
}

