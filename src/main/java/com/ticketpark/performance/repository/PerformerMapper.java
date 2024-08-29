package com.ticketpark.performance.repository;

import com.ticketpark.performance.model.entity.Performer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PerformerMapper {
    void createPerformer(List<Performer> performers);
    Long deletePerfomerByPerformanceId(Long performanceId);
    void deleteAllPerformer();
}
