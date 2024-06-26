package com.ticketpark.ticket.member.controller.response;

import com.ticketpark.ticket.member.model.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class MemberJoinResponse {
    private String id;

    public static MemberJoinResponse fromMemberDto(MemberDto dto){
        return new MemberJoinResponse(
                dto.getId()
        );
    }

}
