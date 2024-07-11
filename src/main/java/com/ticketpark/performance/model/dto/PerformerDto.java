package com.ticketpark.performance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PerformerDto {
    private String name;
    private Long performance_id;


    public PerformerDto(String name){
        this.name = name;
    }
}
