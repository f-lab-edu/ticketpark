package com.ticketpark.performance.controller.request;

import com.ticketpark.performance.model.dto.PerformanceCreateDto;
import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.performance.model.entity.Genre;
import com.ticketpark.performance.model.entity.Performance;
import com.ticketpark.performance.model.entity.Performer;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class PerformanceCreateRequest {
    //공연정보
    @NotNull
    private PerformanceDto performance;
    //가수 정보
    @NotNull
    private List<PerformerDto> performer;
    //티켓 정보
    @NotNull
    private TicketDto ticket;
    //티켓 등급 정보
    @NotNull
    private List<TicketGradeDto> ticketGrade;

    public Performance getPermanceEntity(PerformanceCreateRequest request) {
        PerformanceDto dto = request.getPerformance();

        Performance performance = new Performance();
        performance.setGenre(dto.getGenre());
        performance.setName(dto.getName());
        performance.setPlace(dto.getPlace());
        performance.setStart_dt(dto.getStart_dt());
        performance.setEnd_dt(dto.getEnd_dt());
        performance.setCreated_at(LocalDateTime.now());

        return performance;
    }

    public List<Performer> getPerformerList(Long performanceId, PerformanceCreateRequest request){
        List<Performer> list = new ArrayList<Performer>();
        List<PerformerDto> requestList = request.getPerformer();

        for (PerformerDto dto : requestList) {
            Performer performer = new Performer();
            performer.setName(dto.getName());
            performer.setPerformance_id(performanceId);
            list.add(performer);
        }
        return list;
    }
}
