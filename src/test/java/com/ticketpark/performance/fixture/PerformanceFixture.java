package com.ticketpark.performance.fixture;

import com.ticketpark.common.TestConstants;
import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.entity.Genre;

import java.time.*;

public class PerformanceFixture {
    public static PerformanceDto getPerformanceDto() {
        LocalDateTime performanceStartTime = TestConstants.fixDate.plusDays(10);
        LocalDateTime performanceEndTime = TestConstants.fixDate.plusDays(12);

        return PerformanceDto.builder()
                .genre(Genre.CONCERT)
                .name("2024 SM 통합 콘서트")
                .place("고척돔")
                .start_dt(performanceStartTime)
                .end_dt(performanceEndTime)
                .created_at(LocalDateTime.now())
                .build();
    }
}
