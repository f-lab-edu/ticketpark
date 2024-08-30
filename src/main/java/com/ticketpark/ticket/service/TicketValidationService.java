package com.ticketpark.ticket.service;

import com.ticketpark.common.enums.LockType;
import com.ticketpark.exception.ErrorCode;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//@Service
@RequiredArgsConstructor
public class TicketValidationService {

    private final LockType lockType;
    private final TicketGradeRepository ticketGradeRepository;
    private final TicketOrderRepository ticketOrderRepository;

    @Transactional(readOnly = true)
    public void isFullBooked(TicketOrderDto dto){

        //해당 좌석 등급의 남아있는 티켓 매수 확인
        Integer remainTicketCount = getCountTicketGrade(dto.getTicket_grade_id());
        if(remainTicketCount<=0){
            throw new TicketParkException(ErrorCode.ALL_BOOKED_TICKET
                    , String.format("this ticket grade is all booked / ticket_grade_id : %s", dto.getTicket_grade_id()));
        }
    }

    @Transactional(readOnly = true)
    public void checkBookableTicket(TicketOrderDto orderDto){
        //내가 선택한 좌석이 예매됐는지 확인
        getTickOrderBySeatInfo(orderDto.getPerformance_id()
                        , orderDto.getTicket_grade_id()
                        , orderDto.getSeat_info())
                .ifPresent(t -> {
                    throw new TicketParkException(ErrorCode.BOOKED_TICKET
                            , String.format("this ticket order already booked / ticket_grade_id : %s, seat_info : %s"
                            , orderDto.getTicket_grade_id()
                            , orderDto.getSeat_info()));
                });
    }

    //TODO 락적용 쿼리, 락 적용안한 쿼리로 갈리는데 어떻게 없애야 하나..
    //별도의 팩토리를 만들어야 하나..
    private Integer getCountTicketGrade(Long ticketGradeId){
        return lockType == LockType.PessimisticLock ?
                ticketGradeRepository.getCountTicketByGradeByPessimisticLock(ticketGradeId)
                : ticketGradeRepository.getCountTicketGrade(ticketGradeId);
    }

    private Optional<TicketOrder> getTickOrderBySeatInfo(Long performanceId, Long ticketGradeId, String seatInfo){
        return lockType == LockType.PessimisticLock ?
                ticketOrderRepository.getTickOrderBySeatInfoAndPessimisticLock(performanceId, ticketGradeId, seatInfo)
                : ticketOrderRepository.getTickOrderBySeatInfo(performanceId, ticketGradeId, seatInfo);
    }

}
