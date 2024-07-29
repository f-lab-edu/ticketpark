package com.ticketpark.ticket.service.fixture;

import com.ticketpark.ticket.model.dto.TicketGradeDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketGradeFixture {

    public static List<TicketGradeDto> getLitTicketGradeDto() {
        return Arrays.asList(
                new TicketGradeDto("VIP", "VIP석", 200, 200000.0, LocalDateTime.now())
                ,new TicketGradeDto("R", "R석", 200, 170000.0, LocalDateTime.now())
                ,new TicketGradeDto("S", "S석", 200, 150000.0, LocalDateTime.now())
        );
    }
}
