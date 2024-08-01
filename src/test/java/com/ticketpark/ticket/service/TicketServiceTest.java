package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketCreateDto;
import com.ticketpark.ticket.fixture.TicketFixture;
import com.ticketpark.ticket.fixture.TicketGradeFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    private TicketCreateDto request;

    @BeforeEach
    void setUp() {
        request = new TicketCreateDto(TicketFixture.getTicketDto(), TicketGradeFixture.getLitTicketGradeDto());
    }

    @Test
    @DisplayName("티켓은 공연과 같이 등록되어야 한다")
    void addTicketWithoutPerformance(){
        assertThrows(IllegalTransactionStateException.class, () -> ticketService.createTicket(request));
    }

}