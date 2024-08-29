package com.ticketpark.ticket.service;

import com.ticketpark.exception.ErrorCode;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketGrade;
import com.ticketpark.ticket.model.entity.TicketOrder;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

//@Service
@RequiredArgsConstructor
@Slf4j
public class TicketOrderServiceByOptimisticLock implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;
    private final TicketGradeRepository ticketGradeRepository;

    public void checkBookableTicket(TicketOrderDto orderDto){
        log.debug("2. 내가 선택한 좌석 예매됐는지 확인 / 좌석 등급={}, 좌석정보={}"
                , orderDto.getTicket_grade_id()
                ,orderDto.getSeat_info());

        //내가 선택한 좌석이 예매됐는지 확인
        ticketOrderRepository.getTickOrderBySeatInfo(orderDto.getPerformance_id()
                        , orderDto.getTicket_grade_id()
                        , orderDto.getSeat_info())
                .ifPresent(t -> {
                    throw new TicketParkException(ErrorCode.BOOKED_TICKET
                            , String.format("this ticket order already booked / ticket_grade_id : %s, seat_info : %s"
                            , orderDto.getTicket_grade_id()
                            , orderDto.getSeat_info()));
                });
    }


    public TicketOrder saveTicketOrder(TicketOrderDto orderDto){

        TicketGrade ticketGradeInfo = validateTicketGrade(orderDto);

        //좌석 수 감소
        //update row 없으면 낙관적 락 exception
        Integer rowCnt = ticketGradeRepository.updateSeatCountByByOptimisticLock(
                ticketGradeInfo.getTicket_grade_id()
                , ticketGradeInfo.getVersion());

        if(rowCnt == 0){
            throw new OptimisticLockingFailureException("낙관적 락 발생");
        }
        log.debug("4. 해당 등급 좌석 수 감소 완료 / 좌석 등급 정보={}", orderDto.getTicket_grade_id());

        //티켓 주문 insert
        TicketOrder ticketOrder = orderDto.getEntity();
        ticketOrderRepository.createTicketOrder(ticketOrder);
        log.debug("5. 티켓 예매 정상 완료 / 좌석 등급={}, 좌석 정보={}"
                ,orderDto.getTicket_grade_id()
                , orderDto.getSeat_info());


        return ticketOrder;
    }

    private TicketGrade validateTicketGrade(TicketOrderDto orderDto){
        //좌석 정보 조회
        TicketGrade ticketGradeInfo = ticketGradeRepository.getTicketGrade(orderDto.getTicket_grade_id());
        log.debug("3. 예매 시작 / 현재 좌석 수 = {}", ticketGradeInfo.getSeat_count());

        if(ticketGradeInfo.getSeat_count() <= 0){
            log.debug("3 error 좌석 수 0이라서 예매 불가!!!!!!!");
            throw new TicketParkException(ErrorCode.ALL_BOOKED_TICKET
                    , String.format("this ticket grade is all booked / ticket_grade_id : %s", orderDto.getTicket_grade_id()));
        }

        return ticketGradeInfo;
    }


}
