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

    @PostMapping("/createPerformance")
    public Response<Void> createPerformance(PerformanceCreateRequest requestList) {
        //TODO 공연은 관리자만 등록 가능하므로 관리자 체크는 AOP로 뺄 것
        //공연 추가
        performanceService.createPerformance(requestList);
        return Response.success();
    }
}
