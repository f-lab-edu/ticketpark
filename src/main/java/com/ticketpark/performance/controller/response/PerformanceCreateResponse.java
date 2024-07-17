package com.ticketpark.performance.controller.response;

import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PerformanceCreateResponse {
    //공연정보
    @NotNull
    private PerformanceDto performance;
    //가수 정보
    @NotNull
    private List<PerformerDto> performer;
    //티켓 정보
    @NotNull
    private TicketDto ticket;
    //티켓 등급 정보
    @NotNull
    private List<TicketGradeDto> ticketGrade;
}
