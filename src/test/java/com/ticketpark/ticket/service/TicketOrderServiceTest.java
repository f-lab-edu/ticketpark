package com.ticketpark.ticket.service;

import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.fixture.TicketOrderFixture;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TicketOrderServiceTest {

    @Autowired
    private TicketOrderFacade ticketOrderFacade;

    @Autowired
    private TicketOrderService ticketOrderService;

    private TicketOrderDto ticketOrderDto;


    @DisplayName("예매 안된 좌석 예매하면 예매 가능")
    @Test
    void bookTicketPossible(){
        //given
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-A구역-1열-001");

        //then
        //1층-A구역-1열-001 예매
        ticketOrderFacade.orderTicket(ticketOrderDto);

        //when
        //1층-A구역-1열-002 예매 가능한지 확인
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-A구역-1열-002");
        assertDoesNotThrow(()->ticketOrderService.checkBookableTicket(ticketOrderDto));
    }

    @DisplayName("이미 예약된 좌석을 예매하면 예매 불가능")
    @Test
    void duplicateBookTicket(){
        //given
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-A구역-1열-001");

        //then
        //1층-A구역-1열-001 예매
        ticketOrderFacade.orderTicket(ticketOrderDto);

        //when
        //동일 좌석 예매 가능한지 확인
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-A구역-1열-001");
        assertThrows(TicketParkException.class, ()-> ticketOrderService.checkBookableTicket(ticketOrderDto));
    }


    @DisplayName("티켓 예매 정보 저장")
    @Test
    void saveTicketOrder(){
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto();
        assertDoesNotThrow(()->ticketOrderService.saveTicketOrder(ticketOrderDto));
    }
}