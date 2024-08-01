package com.ticketpark.performance.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

@Getter
public class PerformerDto {
    private String name;

    @JsonCreator
    public PerformerDto(String name){
        this.name = name;
    }
}
