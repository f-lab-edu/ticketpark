package com.ticketpark.ticket.member.repository;

import com.ticketpark.ticket.member.model.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    //회원가입
    void addMember(@Param("member") Member member);

    //회원 조회
    Optional<Member> findById(String id);

    //회원 삭제
    int deleteMember(String id);
}
