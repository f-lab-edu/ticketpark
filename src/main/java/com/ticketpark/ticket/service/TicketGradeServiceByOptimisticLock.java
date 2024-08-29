package com.ticketpark.ticket.service;

import com.ticketpark.exception.ErrorCode;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
@RequiredArgsConstructor
public class TicketGradeServiceByOptimisticLock implements TicketGradeService {
    private final TicketGradeRepository ticketGradeRepository;

    public boolean isFullBooked(TicketOrderDto dto){
        log.debug("1. 해당 등급 예매 전부 됐는지 확인 조회 / 좌석등급={}", dto.getTicket_grade_id());

        //해당 좌석 등급의 남아있는 티켓 매수 확인
        Integer remainTicketCount = ticketGradeRepository.getCountTicketGrade(dto.getTicket_grade_id());
        if(remainTicketCount<=0){
            throw new TicketParkException(ErrorCode.ALL_BOOKED_TICKET
                    , String.format("this ticket grade is all booked / ticket_grade_id : %s", dto.getTicket_grade_id()));
        }
        return true;
    }
}
