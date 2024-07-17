package com.ticketpark.performance.fixture;

import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.entity.Genre;

import java.time.LocalDateTime;

public class PerformanceFixture {
    public static PerformanceDto getPerformanceDto() {

        LocalDateTime performanceStartTime = LocalDateTime.now().plusDays(10);
        LocalDateTime performanceEndTime = LocalDateTime.now().plusDays(12);

        PerformanceDto dto = new PerformanceDto();
        dto.setGenre(Genre.CONCERT);
        dto.setName("2024 SM 통합 콘서트");
        dto.setPlace("고척돔");
        dto.setStart_dt(performanceStartTime);
        dto.setEnd_dt(performanceEndTime);
        dto.setCreated_at(LocalDateTime.now());

        return dto;
    }
}
