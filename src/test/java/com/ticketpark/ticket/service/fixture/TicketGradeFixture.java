package com.ticketpark.ticket.service.fixture;

import com.ticketpark.ticket.model.dto.TicketGradeDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketGradeFixture {

    public static List<TicketGradeDto> getLitTicketGradeDto() {
        List<TicketGradeDto> gradeDtoList = new ArrayList<TicketGradeDto>();
        gradeDtoList.add(new TicketGradeDto("VIP", "VIP석", 200, 200000.0, LocalDateTime.now()));
        gradeDtoList.add(new TicketGradeDto("R", "R석", 200, 170000.0, LocalDateTime.now()));
        gradeDtoList.add(new TicketGradeDto("S", "S석", 200, 150000.0, LocalDateTime.now()));
        return gradeDtoList;
    }
}
