package com.ticketpark.performance.model.entity;

import com.ticketpark.performance.controller.request.PerformanceCreateRequest;
import com.ticketpark.performance.model.dto.PerformerDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Performer {
    private Long performer_id;
    private String name;
    private Long performance_id;

    public static List<Performer> getPerformerList(Long performanceId, PerformanceCreateRequest request){
        List<Performer> list = new ArrayList<Performer>();
        List<PerformerDto> requestList = request.getPerformer();

        for (PerformerDto dto : requestList) {
            Performer performer = new Performer();
            performer.setName(dto.getName());
            performer.setPerformance_id(performanceId);
            list.add(performer);
        }
        return list;
    }


}
