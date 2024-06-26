package com.ticketpark.ticket.member.model.entity;

import com.ticketpark.ticket.member.model.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Member {
    //회원 SID
    //TODO 시간 날떄 UUID 변경 고려할 것..
    private Long member_sid;
    //아이디
    private String id;
    //회원등급
    private MemberRole role;
    //비밀번호
    private String password;
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

    public static Member of(MemberDto memberDto) {
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setRole(memberDto.getRole());
        member.setPassword(memberDto.getPassword());
        member.setEmail(memberDto.getEmail());
        member.setHp_no(memberDto.getHp_no());

        return member;
    }


}
