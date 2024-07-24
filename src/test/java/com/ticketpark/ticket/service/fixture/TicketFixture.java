package com.ticketpark.ticket.service.fixture;

import com.ticketpark.common.TestConstants;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.entity.Ticket;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TicketFixture {

    public static TicketDto getTicketDto() {
        LocalDateTime orderStartTime = TestConstants.fixDate.plusDays(3);
        LocalDateTime orderEndTime = TestConstants.fixDate.plusDays(10);

        return TicketDto.builder()
                .start_dt(orderStartTime)
                .end_dt(orderEndTime)
                .created_dt(LocalDateTime.now())
                .build();
    }
}
