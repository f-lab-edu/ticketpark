package com.ticketpark.ticket.service;

import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.fixture.TicketOrderFixture;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import com.ticketpark.ticket.fixture.TicketGradeFixture;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class TicketGradeServiceTest {

    @Autowired
    private TicketOrderFacade ticketOrderFacade;

    @Autowired
    private TicketGradeService ticketGradeService;

    private TicketOrderDto ticketOrderDto;

    @BeforeEach
    void setUp() {
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto();
    }

    @DisplayName("티켓 수량이 남아있으면 예약 가능")
    @Test
    void bookTicketPossible(){
        assertTrue(ticketGradeService.isFullBooked(ticketOrderDto));
    }

    @DisplayName("티켓 수량이 남아있지 않으면 예약 불가")
    @Test
    void bookTicketNotPossible(){
        //100매 예매
        this.orderMultiTicket(100);
        assertThrows(TicketParkException.class, ()->ticketGradeService.isFullBooked(ticketOrderDto));
    }

    //예약 N건 실행
    private void orderMultiTicket(int ticketCount){
        for(int i=0; i<ticketCount; i++){
            String seatNum = String.valueOf(new Random().nextInt(Integer.MAX_VALUE));
            ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-A구역-"+seatNum);
            ticketOrderFacade.orderTicket(ticketOrderDto);
        }
    }

}