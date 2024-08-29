package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;

public interface TicketOrderFacade{
    public TicketOrder orderTicket(TicketOrderDto orderDto);
}