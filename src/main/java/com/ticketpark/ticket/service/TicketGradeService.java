package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;

public interface TicketGradeService {
    public boolean isFullBooked(TicketOrderDto dto);
}
