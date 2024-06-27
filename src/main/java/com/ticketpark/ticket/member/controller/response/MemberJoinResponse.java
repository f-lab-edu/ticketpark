package com.ticketpark.ticket.member.controller.response;

import com.ticketpark.ticket.member.model.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberJoinResponse {
    private String id;

    public static MemberJoinResponse fromMember(Member member){
        return new MemberJoinResponse(
                member.getId()
        );
    }

}
