package com.ticketpark.performance.repository;

import com.ticketpark.performance.model.entity.Performance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PerformanceMapper {
    void createPerformance(@Param("performance") Performance performance);
}
