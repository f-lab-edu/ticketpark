package com.ticketpark.ticket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.fixture.TicketOrderFixture;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class TicketOrderFacadeTest {

    @Autowired
    TicketOrderFacade ticketOrderFacade;

    TicketOrderDto ticketOrderDto;

    @BeforeEach
    void setUp() {
        this.ticketOrderDto = TicketOrderFixture.getTicketOrderDto();
    }


    @DisplayName("티켓 1매 예약")
    @Test
    void bookOneTicket() throws JsonProcessingException {
        Assertions.assertDoesNotThrow(()->ticketOrderFacade.orderTicket(this.ticketOrderDto));
    }

}