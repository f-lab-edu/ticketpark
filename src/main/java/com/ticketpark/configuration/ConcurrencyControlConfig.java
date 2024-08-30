package com.ticketpark.configuration;

import com.ticketpark.common.enums.LockType;
import com.ticketpark.common.util.TransactionExecutor;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketOrderRepository;
import com.ticketpark.ticket.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConcurrencyControlConfig {

    @Autowired
    private final TicketOrderValidator ticketOrderValidator;

    @Autowired
    private final TransactionExecutor transactionExecutor;

    @Autowired
    private final LockingTicketOrderService defaultTicketOrderService;

    @Autowired
    private final TicketGradeRepository ticketGradeRepository;

    @Autowired
    private final TicketOrderRepository ticketOrderRepository;

    @Bean
    public TicketOrderFacade ticketOrderFacade(){
        return new TicketOrderFacadeByPessimisticLock(ticketOrderValidator, transactionExecutor, defaultTicketOrderService);
        //return new TicketOrderFacadeByOptimisticLock(ticketOrderValidator, defaultTicketOrderService);
        //return new TicketOrderFacadeByNamedLock(namedLockTemplate, ticketOrderValidator, transactionExecutor, defaultTicketOrderService);
    }

    @Bean
    public TicketValidationService ticketValidationService(){
        return new TicketValidationService(LockType.PessimisticLock, ticketGradeRepository, ticketOrderRepository);
    }
}
