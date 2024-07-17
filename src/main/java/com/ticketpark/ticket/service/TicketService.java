package com.ticketpark.ticket.service;

import com.ticketpark.common.response.Response;
import com.ticketpark.ticket.model.dto.TicketCreateDto;
import com.ticketpark.ticket.model.entity.Ticket;
import com.ticketpark.ticket.model.entity.Ticket_grade;
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
        //티켓은 무조건 공연이랑 세트로 저장하기에 전파옵션 MANDATORY
        /*
        * 의미: 트랜잭션이 의무임(트랜잭션이 반드시 필요함)
        기존 트랜잭션 없음: IllegalTransactionStateException 예외 발생
        기존 트랜잭션이 있음: 기존 트랜잭션에 참여함
        *
        * */

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

        ticketGradeRepository.createTicketGrade(Ticket_grade.getPerformerList(ticketId, dto.getTicketGrade()));

        return Response.success();
    }

}
