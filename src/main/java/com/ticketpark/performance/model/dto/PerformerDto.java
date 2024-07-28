package com.ticketpark.performance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PerformerDto {
    private String name;

    public PerformerDto(String name){
        this.name = name;
    }
}
