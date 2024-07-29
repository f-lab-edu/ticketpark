package com.ticketpark.performance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketpark.common.CommonControllerTest;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.fixture.PerformanceFixture;
import com.ticketpark.performance.fixture.PerformanceRequestFixture;
import com.ticketpark.performance.fixture.PerformerFixture;
import com.ticketpark.performance.model.dto.PerformanceDto;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.performance.model.entity.Genre;
import com.ticketpark.performance.model.entity.Performance;
import com.ticketpark.performance.service.PerformanceService;
import com.ticketpark.ticket.model.dto.TicketDto;
import com.ticketpark.ticket.model.dto.TicketGradeDto;
import com.ticketpark.ticket.service.fixture.TicketFixture;
import com.ticketpark.ticket.service.fixture.TicketGradeFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PerformanceControllerTest extends CommonControllerTest {

    @MockBean
    private PerformanceService performanceService;

    @DisplayName("공연/티켓 정보 등록")
    @Test
    void createPerformance() throws Exception {
        PerformanceCreateRequest request = PerformanceRequestFixture.getPerformanceCreateRequest();
        this.executeStatusOk("/api/performance", request);
    }
}