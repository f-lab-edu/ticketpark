package com.ticketpark.performance.controller.request;

import com.ticketpark.performance.model.dto.PerformanceCreateDto;
import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.performance.model.entity.Genre;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PerformanceCreateRequest {
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
