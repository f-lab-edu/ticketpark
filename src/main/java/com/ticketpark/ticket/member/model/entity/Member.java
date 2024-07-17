package com.ticketpark.ticket.member.model.entity;

import com.ticketpark.ticket.member.model.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Member {
    //회원 SID
    private Long member_sid;
    //아이디
    private String id;
    //비밀번호
    private String password;
    //회원등급
    private Role role;
    //이메일
    private String email;
    //핸드폰 번호
    private String hp_no;
    //회원 생성일시
    private Timestamp created_dt;
    //회원 수정일시
    private Timestamp updated_dt;
    //회원 구분
    private MemberStatus use_yn;

    public static Member of(MemberDto dto) {
        Member member = new Member();

        member.setId(dto.getId());
        member.setPassword(dto.getPassword());
        member.setRole(dto.getRole());
        member.setEmail(dto.getEmail());
        member.setHp_no(dto.getHp_no());
        member.setCreated_dt(dto.getCreated_dt());
        member.setUpdated_dt(dto.getUpdated_dt());
        member.setUse_yn(dto.getUse_yn());

        return member;
    }


}
