package com.ticketpark.performance.model.dto;

import com.ticketpark.performance.model.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PerformanceCreateDto {

    //PerformanceDto
    private Genre genre;
    private String name;
    private String place;
    private LocalDateTime start_dt;
    private LocalDateTime end_dt;
    private LocalDateTime created_at;
    private Long performer_id;

    private List<PerformerDto> performer;
}
