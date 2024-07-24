package com.ticketpark.performance.repository;

import com.ticketpark.performance.model.entity.Performer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisPerformerRepository implements PerformerRepository{

    private final PerformerMapper performerMapper;

    @Override
    public void createPerformer(List<Performer> performers) {
        performerMapper.createPerformer(performers);
    }
}
