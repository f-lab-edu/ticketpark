package com.ticketpark.performance.fixture;

import com.ticketpark.performance.model.dto.PerformerDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerformerFixture {

    public static List<PerformerDto> getPerformerDtoList(){
        return Arrays.asList(
                new PerformerDto("에스파")
                ,new PerformerDto("NCT")
                ,new PerformerDto("라이즈")
        );
    }
}
