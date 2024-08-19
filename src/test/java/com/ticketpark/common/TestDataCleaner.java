package com.ticketpark.common;

import com.ticketpark.member.repository.MemberRepository;
import com.ticketpark.performance.repository.PerformanceRepository;
import com.ticketpark.performance.repository.PerformerRepository;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import com.ticketpark.ticket.repository.TicketOrderRepository;
import com.ticketpark.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDataCleaner {

    //region [private]
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private PerformerRepository performerRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketGradeRepository ticketGradeRepository;

    @Autowired
    private TicketOrderRepository ticketOrderRepository;
    //endregion

    @Transactional
    public void cleanAll() {

        memberRepository.deleteAllMember();
        performanceRepository.deleteAllPerformance();
        performerRepository.deleteAllPerformer();
        ticketRepository.deleteAllTicket();
        ticketGradeRepository.deleteAllTicketGrade();
        ticketOrderRepository.deleteAllTicketOrder();
    }
}
