package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.fixture.TicketOrderFixture;

import com.ticketpark.ticket.model.entity.TicketOrder;
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
        request = TicketOrderFixture.getTicketOrderDto();
    }


    @DisplayName("티켓 1매 정상 예약")
    @Test
    void bookOneTicket()  {
        //when
        TicketOrder insertTicketOrder =ticketOrderFacade.orderTicket(request);

        //then
        TicketOrder getTicketOrder = ticketOrderRepository.getTickOrder(insertTicketOrder.getTicket_order_id()).get();
        assertThat(insertTicketOrder).usingRecursiveComparison().isEqualTo(getTicketOrder);
    }
}
