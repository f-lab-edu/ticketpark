//package com.ticketpark.ticket.service;
//
//import com.ticketpark.exception.ErrorCode;
//import com.ticketpark.exception.TicketParkException;
//import com.ticketpark.ticket.model.dto.TicketOrderDto;
//import com.ticketpark.ticket.repository.TicketGradeRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.transaction.annotation.Transactional;
//
////@Service
//@RequiredArgsConstructor
//public class TicketGradeServiceByPessimisticLock implements TicketGradeService {
//    private final TicketGradeRepository ticketGradeRepository;
//
//    @Transactional(readOnly = true)
//    public boolean isFullBooked(TicketOrderDto dto){
//        //해당 좌석 등급의 남아있는 티켓 매수 확인
//        Integer remainTicketCount = ticketGradeRepository.getCountTicketByGradeByPessimisticLock(dto.getTicket_grade_id());
//        if(remainTicketCount<=0){
//            throw new TicketParkException(ErrorCode.ALL_BOOKED_TICKET
//                    , String.format("this ticket grade is all booked / ticket_grade_id : %s", dto.getTicket_grade_id()));
//        }
//        return true;
//    }
//}
