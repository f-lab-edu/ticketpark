package com.ticketpark.performance.service;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.model.dto.PerformerDto;
import com.ticketpark.performance.model.entity.Genre;
import com.ticketpark.performance.model.entity.Performer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PerformanceServiceTest {
    @Autowired
    private PerformanceService performanceService;

    private List<PerformanceCreateRequest> requestList;

    @BeforeEach
    void beforeEach(){
        requestList = new ArrayList<>();
        PerformanceCreateRequest request = new PerformanceCreateRequest();

        //공연정보
        request.setGenre(Genre.CONCERT);
        request.setName("2024 SM 통합 콘서트");
        request.setPlace("고척돔");
        request.setStart_dt(LocalDateTime.now());
        request.setEnd_dt(LocalDateTime.now());
        request.setCreated_at(LocalDateTime.now());


        List<PerformerDto> list =  new ArrayList<>();
        list.add(new PerformerDto("에스파"));
        list.add(new PerformerDto("NCT"));
        list.add(new PerformerDto("라이즈"));
        request.setPerformer(list);

        requestList.add(request);
    }

    @Test
    @DisplayName("공연 등록")
    void createPerformance() {
        performanceService.addPerformance(requestList);
    }
}