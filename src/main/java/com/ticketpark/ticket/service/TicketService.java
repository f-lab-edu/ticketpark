package com.ticketpark.ticket.service;

import com.ticketpark.common.response.Response;
import com.ticketpark.ticket.model.dto.TicketCreateDto;
import com.ticketpark.ticket.model.entity.Ticket;
import com.ticketpark.ticket.model.entity.TicketGrade;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    
    private final TicketRepository ticketRepository;
    private final TicketGradeRepository ticketGradeRepository;
    
    @Transactional(propagation = Propagation.MANDATORY)
    public Response<Void> createTicket(TicketCreateDto dto) {
        //----------------------------
        //티켓 정보 등록
        //----------------------------
        Ticket ticket = Ticket.of(dto.getTicket());
        ticketRepository.createTicket(ticket);

        //----------------------------
        //좌석 정보 등록
        //----------------------------
        Long ticketId = ticket.getTicket_id();
        Optional.ofNullable(ticketId).orElseThrow(() ->
            new IllegalArgumentException("table Ticket pk is null")
        );

        ticketGradeRepository.createTicketGrade(TicketGrade.getPerformerList(ticketId, dto.getTicketGrade()));

        return Response.success();
    }

}
