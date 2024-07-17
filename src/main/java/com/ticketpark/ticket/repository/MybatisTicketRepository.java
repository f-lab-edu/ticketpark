package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisTicketRepository implements TicketRepository{

    private final TicketMapper ticketMapper;

    @Override
    public void createTicket(Ticket ticket) {
        ticketMapper.createTicket(ticket);
    }
}
