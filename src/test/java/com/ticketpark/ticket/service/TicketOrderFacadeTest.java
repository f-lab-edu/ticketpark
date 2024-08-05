package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.fixture.TicketOrderFixture;

import com.ticketpark.ticket.repository.TicketOrderRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class TicketOrderFacadeTest {

    @Autowired
    TicketOrderRepository ticketOrderRepository;

    @Autowired
    TicketOrderFacade ticketOrderFacade;

    TicketOrderDto request;

    @BeforeEach
    void setUp() {
        this.request = TicketOrderFixture.getTicketOrderDto();
    }


    @DisplayName("티켓 1매 정상 예약")
    @Test
    void bookOneTicket()  {
        //when
        ticketOrderFacade.orderTicket(this.request);

        //then
        assertThat(ticketOrderRepository.getTickOrder(request.getTicket_grade_id()).get()).isNotNull();
    }

}