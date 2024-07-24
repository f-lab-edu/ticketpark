package com.ticketpark.performance.model.dto;

import com.ticketpark.performance.model.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class PerformanceDto {
    private Genre genre;
    private String name;
    private String place;
    private LocalDateTime start_dt;
    private LocalDateTime end_dt;
    private LocalDateTime created_at;
    private Long performer_id;

    @Builder
    public PerformanceDto(Genre genre, String name, String place, LocalDateTime start_dt, LocalDateTime end_dt, LocalDateTime created_at){
        this.genre = genre;
        this.name = name;
        this.place = place;
        this.start_dt = start_dt;
        this.end_dt = end_dt;
        this.created_at = created_at;
    }
}
