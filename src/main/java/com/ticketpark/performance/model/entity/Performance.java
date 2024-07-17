package com.ticketpark.performance.model.entity;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.model.dto.PerformanceDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Performance {
    private Long performance_id;
    private Genre genre;
    private String name;
    private String place;
    private LocalDateTime start_dt;
    private LocalDateTime end_dt;
    private LocalDateTime created_at;

    public static Performance of(PerformanceCreateRequest request) {
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
}
