package com.ticketpark.ticket.service;

import com.ticketpark.common.util.NamedLockTemplate;
import com.ticketpark.common.util.TransactionExecutor;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TicketOrderFacadeByNamedLock implements TicketOrderFacade {

    private final NamedLockTemplate namedLockTemplate;
    private final TicketOrderValidator ticketOrderValidator;
    private final TransactionExecutor transactionExecutor;
    private final LockingTicketOrderService defaultTicketOrderService;

    @Transactional
    public TicketOrder orderTicket(TicketOrderDto orderDto){
        TicketOrder orderResult = null;

        namedLockTemplate.execute("ticket_order", 300, () -> {
            ticketOrderValidator.validate(orderDto);
            //TODO 람다 캡처링 오류 해결해야 함
            transactionExecutor.executeWithRequireNew(() -> {
                return defaultTicketOrderService.defaultSaveTicketOrder(orderDto);
            });
        });

        //람다 캡쳐링으로 인해서 티켓 예매 response 리턴 안되어서 일단 NULL 리턴
        return orderResult;
    }

}