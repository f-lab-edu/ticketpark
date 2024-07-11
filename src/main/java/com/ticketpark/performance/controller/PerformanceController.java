package com.ticketpark.performance.controller;

import com.ticketpark.common.response.Response;
import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping("/addPerformance")
    public Response<Void> addPerformance(List<PerformanceCreateRequest> requestList) {
        //TODO 관리자 인증 추가 필요

        //공연 추가
        performanceService.addPerformance(requestList);
        return Response.success();
    }
}
