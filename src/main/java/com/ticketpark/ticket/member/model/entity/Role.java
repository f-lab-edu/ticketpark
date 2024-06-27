package com.ticketpark.ticket.member.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    USER("U"),
    ADMIN("A");

    private final String value;

    @JsonCreator
    public static Role from(String value){
        for(Role role : Role.values()){
            if(role.value.equals(value)){
                return role;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
