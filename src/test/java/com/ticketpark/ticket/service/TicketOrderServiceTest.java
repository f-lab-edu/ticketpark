package com.ticketpark.ticket.service;

import com.ticketpark.exception.TicketParkException;
import com.ticketpark.ticket.fixture.TicketOrderFixture;
import com.ticketpark.ticket.model.dto.TicketOrderDto;
import com.ticketpark.ticket.repository.TicketGradeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TicketOrderServiceTest {

    @Autowired
    private TicketOrderFacade ticketOrderFacade;

    @Autowired
    private TicketOrderService ticketOrderService;

    private TicketOrderDto ticketOrderDto;

    @Transactional
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

    @Transactional
    @DisplayName("이미 예약된 좌석을 예매하면 예매 불가능")
    @Test
    void duplicateBookTicket(){
        //given
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-B구역-1열-001");

        //then
        //1층-A구역-1열-001 예매
        ticketOrderFacade.orderTicket(ticketOrderDto);

        //when
        //동일 좌석 예매 가능한지 확인
        ticketOrderDto = TicketOrderFixture.getTicketOrderDto("1층-B구역-1열-001");
        assertThrows(TicketParkException.class, ()-> ticketOrderService.checkBookableTicket(ticketOrderDto));
    }


    @DisplayName("티켓 수/티켓 중복 예매 유효성 체크 없이 예매하면 트랜잭션 전파 exception 발생")
    @Test
    void saveTicketOrder(){
        assertThrows(IllegalTransactionStateException.class,()->ticketOrderService.saveTicketOrder(ticketOrderDto));
    }
}