package com.ticketpark.performance.fixture;

import com.ticketpark.performance.model.dto.PerformerDto;

import java.util.ArrayList;
import java.util.List;

public class PerformerFixture {

    public static List<PerformerDto> getPerformerDtoList(){
        List<PerformerDto> performerList =  new ArrayList<>();
        performerList.add(new PerformerDto("에스파"));
        performerList.add(new PerformerDto("NCT"));
        performerList.add(new PerformerDto("라이즈"));
        return performerList;
    }
}
