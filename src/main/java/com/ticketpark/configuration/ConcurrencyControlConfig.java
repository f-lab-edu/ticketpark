package com.ticketpark.configuration;

import com.ticketpark.common.repository.MariaDBNamedLockRepository;
import com.ticketpark.common.repository.NameLockRepository;
import com.ticketpark.common.repository.NamedLockMapper;
import com.ticketpark.ticket.repository.*;
import com.ticketpark.ticket.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ConcurrencyControlConfig {

    @Autowired
    private final TicketGradeMapper ticketGradeMapper;

    @Autowired
    private final TicketOrderMapper ticketOrderMapper;

    @Autowired
    private final NamedLockMapper nameLockMapper;

    @Bean
    public TicketOrderFacade ticketOrderFacade(){
        return new TicketOrderFacadeByPessimisticLock(ticketGradeService(), ticketOrderService());
        //return new TicketOrderFacadeByOptimisticLock(ticketGradeService(), ticketOrderService());
        //return new TicketOrderFacadeByNamedLock(nameLockRepository(), ticketGradeService(), ticketOrderService());
    }

    @Bean
    public TicketGradeService ticketGradeService(){
        return new TicketGradeServiceByPessimisticLock(ticketGradeRepository());
        //return new TicketGradeServiceByOptimisticLock(ticketGradeRepository());
        //return new TicketGradeServiceByNamedLock(ticketGradeRepository());
    }

    @Bean
    public TicketOrderService ticketOrderService(){
        return new TicketOrderServiceByPessimisticLock(ticketOrderRepository(), ticketGradeRepository());
        //return new TicketOrderServiceByOptimisticLock(ticketOrderRepository(), ticketGradeRepository());
        //return new TicketOrderServiceByNamedLock(ticketOrderRepository(), ticketGradeRepository());
    }

    @Bean
    public NameLockRepository nameLockRepository(){
        return new MariaDBNamedLockRepository(nameLockMapper);
    }

    @Bean
    public TicketGradeRepository ticketGradeRepository(){
        return new MybatisTicketGradeRepository(ticketGradeMapper);
    }

    @Bean
    public TicketOrderRepository ticketOrderRepository(){
        return new MyBatisTicketOrderRepository(ticketOrderMapper);
    }

}
