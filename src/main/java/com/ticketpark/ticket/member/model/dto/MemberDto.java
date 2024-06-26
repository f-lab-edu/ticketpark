package com.ticketpark.ticket.member.model.dto;

import com.ticketpark.ticket.member.model.entity.Member;
import com.ticketpark.ticket.member.model.entity.MemberRole;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private String id;
    private MemberRole role;
    private String password;
    private String email;
    private String hp_no;
    private Timestamp created_dt;
    private Timestamp update_dt;
    private MemberStatus use_yn;

    public MemberDto(String id,String password) {
        this.id = id;
        this.role = role;
        this.password = password;
        this.email = email;
        this.hp_no = hp_no;
    }

    public static MemberDto fromEntity(Member entity) {
        return new MemberDto(
                entity.getId(),
                entity.getPassword()

        );
    }
}
