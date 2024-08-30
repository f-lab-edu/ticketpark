package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TicketOrderFacadeByOptimisticLock implements TicketOrderFacade {

    private final TicketOrderValidator ticketOrderValidator;
    private final LockingTicketOrderService defaultTicketOrderService;

    @OptimisticLockRetry
    public TicketOrder orderTicket(TicketOrderDto orderDto){
        ticketOrderValidator.validate(orderDto);
        return defaultTicketOrderService.saveTicketOrderWithOptimisticLock(orderDto);
    }

}