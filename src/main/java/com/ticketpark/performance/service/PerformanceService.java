package com.ticketpark.performance.service;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.model.dto.PerformanceCreateDto;
import com.ticketpark.performance.model.entity.Performance;
import com.ticketpark.performance.model.entity.Performer;
import com.ticketpark.performance.repository.PerformanceRepository;
import com.ticketpark.performance.repository.PerformerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final PerformerRepository performerRepository;

    @Transactional
    public void addPerformance(List<PerformanceCreateRequest> requestList) {
        requestList.forEach(request -> {
            Performance performance = Performance.of(request);
            //공연 등록
            performanceRepository.createPerformance(performance);
            //공연 가수 정보 등록
            request.setPerformance_id(performance.getPerformance_id());
            performerRepository.createPerformer(Performer.getPerformerList(request));
        });
    }
}
