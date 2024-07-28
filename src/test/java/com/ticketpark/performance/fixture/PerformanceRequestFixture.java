package com.ticketpark.performance.fixture;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.ticket.service.fixture.TicketFixture;
import com.ticketpark.ticket.service.fixture.TicketGradeFixture;

public class PerformanceRequestFixture {
    public static PerformanceCreateRequest getPerformanceCreateRequest() {
        return PerformanceCreateRequest.builder()
                .performance(PerformanceFixture.getPerformanceDto())
                .performer(PerformerFixture.getPerformerDtoList())
                .ticket(TicketFixture.getTicketDto())
                .ticketGrade(TicketGradeFixture.getLitTicketGradeDto())
                .build();
    }

    public static PerformanceCreateRequest getEmptyTicketPerformanceCreateRequest(){
        return PerformanceCreateRequest.builder()
                .performance(PerformanceFixture.getPerformanceDto())
                .performer(PerformerFixture.getPerformerDtoList())
                .ticket(null)
                .ticketGrade(null)
                .build();
    }
}
