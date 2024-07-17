package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketCreateDto;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import com.ticketpark.ticket.service.fixture.TicketFixture;
import com.ticketpark.ticket.service.fixture.TicketGradeFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.IllegalTransactionStateException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
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
        //티켓만 insert 시 트랜잭션 전파 옵션으로 인한 exception 발생
        Assertions.assertThrows(IllegalTransactionStateException.class, () -> ticketService.createTicket(request));
    }

}