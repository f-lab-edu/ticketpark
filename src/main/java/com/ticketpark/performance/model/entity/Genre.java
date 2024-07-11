package com.ticketpark.performance.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Genre {
    CONCERT("CO"),
    ;
    private final String value;

    @JsonCreator
    public static Genre from(String value) {
        for(Genre genre: Genre.values()){
            if(genre.getValue().equals(value)){
                return genre;
            }
        }
        return null;
    }


    @JsonValue
    public String getValue() {
        return value;
    }


}
