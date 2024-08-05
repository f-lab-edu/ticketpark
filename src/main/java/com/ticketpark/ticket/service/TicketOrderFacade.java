package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.model.entity.TicketOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TicketOrderFacade {

    private final TicketGradeService ticketGradeService;
    private final TicketOrderService ticketOrderService;

    @Transactional
    public TicketOrder orderTicket(TicketOrderDto orderDto){
        ticketGradeService.isFullBooked(orderDto);
        ticketOrderService.checkBookableTicket(orderDto);
        return saveTicketOrder(orderDto);
    }

    private TicketOrder saveTicketOrder(TicketOrderDto orderDto){
        return ticketOrderService.saveTicketOrder(orderDto);
    }

}
