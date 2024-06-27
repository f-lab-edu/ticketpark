package com.ticketpark.ticket.member.controller.request;

import com.ticketpark.ticket.member.model.dto.MemberDto;
import com.ticketpark.ticket.member.model.entity.Role;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinRequest {
    private String id;
    private Role role;
    private String password;
    private String email;
    private String hp_no;
    private Timestamp created_dt;
    private Timestamp updated_dt;
    private MemberStatus use_yn;

    public MemberDto fromJoinRequest(MemberJoinRequest request){
        return new MemberDto(
                request.getId(),
                request.getRole(),
                request.getPassword(),
                request.getEmail(),
                request.getHp_no(),
                request.getCreated_dt() == null ? Timestamp.from(Instant.now()) : request.getCreated_dt(),
                request.getUpdated_dt() == null ? Timestamp.from(Instant.now()) : request.getUpdated_dt(),
                request.getUse_yn()
        );
    }
}
