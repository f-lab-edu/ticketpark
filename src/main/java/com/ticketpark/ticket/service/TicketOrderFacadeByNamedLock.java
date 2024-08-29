package com.ticketpark.ticket.service;

import com.ticketpark.common.repository.NameLockRepository;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TicketOrderFacadeByNamedLock implements TicketOrderFacade {

    private final NameLockRepository nameLockRepository;
    private final TicketGradeService ticketGradeService;
    private final TicketOrderService ticketOrderService;

    @Transactional
    public TicketOrder orderTicket(TicketOrderDto orderDto){
        TicketOrder orderResult;
        try{
            nameLockRepository.getLock("ticket_order", 300);
            ticketGradeService.isFullBooked(orderDto);
            ticketOrderService.checkBookableTicket(orderDto);
            orderResult = saveTicketOrder(orderDto);
        }finally {
            nameLockRepository.releaseLock("ticket_order");
        }
        return orderResult;
    }

    private TicketOrder saveTicketOrder(TicketOrderDto orderDto){
        return ticketOrderService.saveTicketOrder(orderDto);
    }

}