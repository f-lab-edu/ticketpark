package com.ticketpark.member.repository;

import com.ticketpark.member.model.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    //회원가입
    void addMember(Member member);
    //회원 조회
    Optional<Member> findById(String id);

    int deleteMember(String id);
}
