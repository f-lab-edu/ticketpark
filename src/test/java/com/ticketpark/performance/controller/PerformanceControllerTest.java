package com.ticketpark.performance.controller;

import com.ticketpark.common.CommonControllerTest;
import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.fixture.PerformanceRequestFixture;
import com.ticketpark.performance.service.PerformanceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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