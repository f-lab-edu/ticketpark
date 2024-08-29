package com.ticketpark.ticket.fixture;

import com.ticketpark.common.TestConstants;
import com.ticketpark.ticket.controller.request.TicketOrderRequest;
import com.ticketpark.ticket.model.dto.TicketDto;
import java.time.LocalDateTime;

public class TicketFixture {

    public static TicketOrderRequest getTicketOrderRequest() {
        return TicketOrderRequest.builder()
                .member_id(1L)
                .performance_id(1L)
                .ticket_grade_id(1L)
                .seat_info("1층-C구역-17열-10")
                .build();

    }

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
