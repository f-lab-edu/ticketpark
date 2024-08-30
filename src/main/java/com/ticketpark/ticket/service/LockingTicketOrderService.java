package com.ticketpark.ticket.service;

import com.ticketpark.exception.ErrorCode;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketGrade;
import com.ticketpark.ticket.model.entity.TicketOrder;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LockingTicketOrderService {

    private final TicketGradeRepository ticketGradeRepository;
    private final TicketOrderRepository ticketOrderRepository;

    //region [기본 티켓 예매] - 낙관적 락 제외한 티켓 예매
    public TicketOrder defaultSaveTicketOrder(TicketOrderDto orderDto){
        //좌석 수 감소
        ticketGradeRepository.updateSeatCount(orderDto.getPerformance_id());
        //티켓 주문 insert
        TicketOrder ticketOrder = orderDto.getEntity();
        ticketOrderRepository.createTicketOrder(ticketOrder);

        return ticketOrder;
    }
    //endregion

    //region [낙관적 락 적용한 티켓 예매] - 버전 체크로 인해 로직이 다름
    public TicketOrder saveTicketOrderWithOptimisticLock(TicketOrderDto orderDto){
        TicketGrade ticketGradeInfo = validateTicketGrade(orderDto);

        //티켓 버전 체크 후, 문제 없으면 티켓 수 감소
        checkVersionAndUpdateTicketCount(ticketGradeInfo.getTicket_grade_id(), ticketGradeInfo.getVersion());

        //티켓 주문 insert
        TicketOrder ticketOrder = orderDto.getEntity();
        ticketOrderRepository.createTicketOrder(ticketOrder);

        return ticketOrder;
    }

    private TicketGrade validateTicketGrade(TicketOrderDto orderDto){
        //좌석 정보 조회
        TicketGrade ticketGradeInfo = ticketGradeRepository.getTicketGrade(orderDto.getTicket_grade_id());

        if(ticketGradeInfo.getSeat_count() <= 0){
            throw new TicketParkException(ErrorCode.ALL_BOOKED_TICKET
                    , String.format("this ticket grade is all booked / ticket_grade_id : %s", orderDto.getTicket_grade_id()));
        }

        return ticketGradeInfo;
    }

    private void checkVersionAndUpdateTicketCount(Long ticketGradeId, Long version){
        Integer updateRowCount = ticketGradeRepository.updateSeatCountByByOptimisticLock(ticketGradeId, version);
        if(updateRowCount == 0){
            throw new OptimisticLockingFailureException("버전 충돌로 낙관적 락 발생했습니다.");
        }
    }
    //endregion
}
