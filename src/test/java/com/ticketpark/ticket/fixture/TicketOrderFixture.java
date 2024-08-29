package com.ticketpark.ticket.fixture;

import com.ticketpark.common.TestConstants;
import com.ticketpark.member.fixture.MemberFixture;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TicketOrderFixture {
    public static TicketOrderDto getTicketOrderDto() {
        return TicketOrderDto.builder()
                .member_id(TestConstants.defaultMemberId)
                .performance_id(TestConstants.defaultPerformanceId)
                .ticket_grade_id(TestConstants.defaultTicketGradeId)
                .seat_info(TestConstants.defaultSeatInfo)
                .created_dt(LocalDateTime.now())
                .build();
    }

    public static TicketOrderDto getTicketOrderDto(String seatInfo) {
        return TicketOrderDto.builder()
                .member_id(TestConstants.defaultMemberId)
                .performance_id(TestConstants.defaultPerformanceId)
                .ticket_grade_id(TestConstants.defaultTicketGradeId)
                .seat_info(seatInfo)
                .created_dt(LocalDateTime.now())
                .build();
    }

}
