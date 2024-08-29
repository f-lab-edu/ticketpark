package com.ticketpark.ticket.controller;

import com.ticketpark.common.CommonControllerTest;
import com.ticketpark.ticket.controller.request.TicketOrderRequest;
import com.ticketpark.ticket.model.entity.TicketOrder;
import com.ticketpark.ticket.service.TicketOrderFacade;
import com.ticketpark.ticket.fixture.TicketFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketControllerTest extends CommonControllerTest {

    @MockBean
    private TicketOrderFacade ticketOrderFacade;

    private TicketOrderRequest request;

    @DisplayName("티켓 1매 예약")
    @Test
    void createTicketOrder() throws Exception {
        //given
        request = TicketFixture.getTicketOrderRequest();
        //when
        when(ticketOrderFacade.orderTicket(any())).thenReturn(mock(TicketOrder.class));
        //then
        this.executeStatusOk("/api/ticket/order", request);
    }

}