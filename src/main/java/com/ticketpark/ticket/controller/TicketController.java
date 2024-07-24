package com.ticketpark.ticket.controller;

import com.ticketpark.common.response.Response;
import com.ticketpark.ticket.controller.request.TicketOrderRequest;
import com.ticketpark.ticket.controller.request.TicketOrderResponse;
import com.ticketpark.ticket.service.TicketOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketOrderService ticketOrderService;

    @PostMapping("/order")
    public Response<TicketOrderResponse> create(TicketOrderRequest request){
        ticketOrderService.create(request);
        return Response.success(new TicketOrderResponse());
    }

}
