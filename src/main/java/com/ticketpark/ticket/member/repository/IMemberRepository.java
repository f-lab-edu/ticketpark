package com.ticketpark.ticket.member.repository;

import com.ticketpark.ticket.member.model.entity.Member;

import java.util.Optional;

public interface IMemberRepository {

    //회원가입
    public Member addMember(Member member);
    //회원 조회
    public Optional<Member> findById(String id);
}
