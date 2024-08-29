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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Service
@RequiredArgsConstructor
@Slf4j
public class TicketOrderServiceByNamedLock implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;
    private final TicketGradeRepository ticketGradeRepository;

    @Transactional(readOnly = true)
    public void checkBookableTicket(TicketOrderDto orderDto){
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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TicketOrder saveTicketOrder(TicketOrderDto orderDto){
        //좌석 수 감소
        ticketGradeRepository.updateSeatCount(orderDto.getPerformance_id());
        //티켓 주문 insert
        TicketOrder ticketOrder = orderDto.getEntity();
        ticketOrderRepository.createTicketOrder(ticketOrder);

        return ticketOrder;
    }

}
