package com.ticketpark.performance.controller.request;

import com.ticketpark.performance.model.dto.PerformanceCreateDto;
import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.performance.model.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PerformanceCreateRequest {

    //공연정보
    private Long performance_id;
    private Genre genre;
    private String name;
    private String place;
    private LocalDateTime start_dt;
    private LocalDateTime end_dt;
    private LocalDateTime created_at;

    //가수 정보
    private List<PerformerDto> performer;
}
