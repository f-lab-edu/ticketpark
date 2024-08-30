package com.ticketpark.ticket.service;

import com.ticketpark.common.util.TransactionExecutor;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TicketOrderFacadeByPessimisticLock implements TicketOrderFacade{

    private final TicketOrderValidator ticketOrderValidator;
    private final TransactionExecutor transactionExecutor;
    private final LockingTicketOrderService defaultTicketOrderService;

    @Transactional
    public TicketOrder orderTicket(TicketOrderDto orderDto){
        ticketOrderValidator.validate(orderDto);
        return transactionExecutor.executeWithMandatory(() -> {
            return defaultTicketOrderService.defaultSaveTicketOrder(orderDto);
        });
    }

}