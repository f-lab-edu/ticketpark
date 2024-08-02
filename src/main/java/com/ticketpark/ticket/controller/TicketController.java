package com.ticketpark.ticket.controller;

import com.ticketpark.common.response.Response;
import com.ticketpark.ticket.controller.request.TicketOrderRequest;
import com.ticketpark.ticket.controller.request.TicketOrderResponse;
import com.ticketpark.ticket.model.entity.TicketOrder;
import com.ticketpark.ticket.service.TicketOrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketOrderFacade ticketOrderFacade;

    @PostMapping("/order")
    public Response<TicketOrderResponse> create(@RequestBody TicketOrderRequest request){
        TicketOrder ticketOrder = ticketOrderFacade.orderTicket(request.fromRequest(request));
        return Response.success(TicketOrderResponse.fromTicketOrder(ticketOrder));
    }

}
