package com.ticketpark.ticket.service.fixture;

import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.entity.Ticket;

import java.time.LocalDateTime;

public class TicketFixture {

    public static TicketDto getTicketDto() {
        LocalDateTime orderStartTime = LocalDateTime.now().plusDays(3);
        LocalDateTime orderEndTime = LocalDateTime.now().plusDays(10);

        TicketDto ticketDto = new TicketDto();
        ticketDto.setStart_dt(orderStartTime);
        ticketDto.setEnd_dt(orderEndTime);
        ticketDto.setCreated_dt(LocalDateTime.now());

        return ticketDto;
    }
}
