package com.ticketpark.ticket.member.controller.request;

import com.ticketpark.ticket.member.model.dto.MemberDto;
import com.ticketpark.ticket.member.model.entity.MemberRole;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자
public class MemberJoinRequest {

    private String id;
    //private MemberRole role;
    private String password;
    //private String email;
    //private String hp_no;
    //private Timestamp created_dt;
    //private Timestamp update_dt;
    //private MemberStatus use_yn;

    public MemberDto fromJoinRequest(MemberJoinRequest request){
        return new MemberDto(request.getId()
                //, request.getRole()
                , request.getPassword()
                //, request.getEmail()
                //, request.getHp_no()
                //, request.use_yn
        );
    }
}
