package com.ticketpark.ticket.service;

import com.ticketpark.ticket.model.dto.TicketOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketOrderValidator {

    private final TicketValidationService ticketValidationService;

    private List<Runnable> getValidateAction(TicketOrderDto ticketOrderDto){
        //추 후 유효성 체크 추가될 경우, 여기에 관련 메소드만 정의
        List<Runnable> actions = new ArrayList<>();

        actions.add(() -> {ticketValidationService.isFullBooked(ticketOrderDto);});
        actions.add(() -> {ticketValidationService.checkBookableTicket(ticketOrderDto);});

        return actions;
    }

    public void validate(TicketOrderDto ticketOrderDto){
        List<Runnable> validateAction = getValidateAction(ticketOrderDto);
        for (Runnable action : validateAction) {
            action.run();
        }
    }

}
