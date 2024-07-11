package com.ticketpark.performance.repository;

import com.ticketpark.member.repository.MemberMapper;
import com.ticketpark.performance.model.entity.Performance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MybatisPerformanceRepository implements PerformanceRepository {

    private final PerformanceMapper performanceMapper;

    @Override
    public void createPerformance(Performance performance) {
        performanceMapper.createPerformance(performance);
    }
}
