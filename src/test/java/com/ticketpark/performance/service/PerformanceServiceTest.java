package com.ticketpark.performance.service;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.fixture.PerformanceFixture;
import com.ticketpark.performance.fixture.PerformanceRequestFixture;
import com.ticketpark.performance.fixture.PerformerFixture;
import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.performance.model.entity.Genre;
import com.ticketpark.performance.model.entity.Performer;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import com.ticketpark.ticket.service.fixture.TicketFixture;
import com.ticketpark.ticket.service.fixture.TicketGradeFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PerformanceServiceTest {
    @Autowired
    private PerformanceService performanceService;

    private PerformanceCreateRequest request;

    @DisplayName("공연/티켓정보 정상 동작")
    @Test
    void createPerformance(){
        request = PerformanceRequestFixture.getPerformanceCreateRequest();
        Assertions.assertDoesNotThrow(() -> performanceService.create(request));
    }

    @DisplayName("티켓 정보 없이 공연 등록 불가")
    @Test
    void createPerformanceWithoutTicket(){
        request = PerformanceRequestFixture.getEmptyTicketPerformanceCreateRequest();
        assertThrows(NullPointerException.class, () -> performanceService.create(request));
    }

}