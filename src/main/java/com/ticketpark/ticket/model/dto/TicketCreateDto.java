package com.ticketpark.ticket.model.dto;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TicketCreateDto {
    private TicketDto ticket;
    private List<TicketGradeDto> ticketGrade;

    public static TicketCreateDto fromRequest(PerformanceCreateRequest request){
        return new TicketCreateDto(request.getTicket(), request.getTicketGrade());
    }
}
