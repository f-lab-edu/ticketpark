package com.ticketpark.performance.repository;

import com.ticketpark.performance.model.entity.Performer;

import java.util.List;

public interface PerformerRepository {
    void createPerformer(List<Performer> performers);
    void deleteAllPerformer();
}
