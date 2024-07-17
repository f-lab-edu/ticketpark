package com.ticketpark.ticket.repository;

import com.ticketpark.ticket.model.entity.Ticket;

public interface TicketRepository {
    void createTicket(Ticket ticket);
}
