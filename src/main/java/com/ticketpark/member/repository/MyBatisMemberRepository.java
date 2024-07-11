package com.ticketpark.member.repository;

import com.ticketpark.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public void addMember(Member member) {
        memberMapper.addMember(member);
    }

    @Override
    public Optional<Member> findById(String id) {
        return memberMapper.findById(id);
    }

    @Override
    public int deleteMember(String id) {
        return memberMapper.deleteMember(id);
    }
}
