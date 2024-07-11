package com.ticketpark.member.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberStatus {
    USE('Y'),
    NON_USE('N');

    private final char value;

    @JsonCreator
    public static MemberStatus from(char value){
        for (MemberStatus memberStatus : MemberStatus.values()) {
            if(memberStatus.value == value){
                return memberStatus;
            }
        }
        return null;
    }

    @JsonValue
    public char getValue(){
        return value;
    }
}
