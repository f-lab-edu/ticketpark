package com.ticketpark.member.service;

import com.ticketpark.exception.ErrorCode;
import com.ticketpark.exception.TicketParkException;
import com.ticketpark.member.model.dto.MemberDto;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member join(MemberDto memberDto) {
        //아이디 중복 체크
        memberRepository.findById(memberDto.getId()).ifPresent(m -> {
            throw new TicketParkException(ErrorCode.DUPLICATE_ID, String.format("id is %s", memberDto.getId()));
        });

        //회원가입
        Member member = Member.of(memberDto);
        memberRepository.addMember(member);

        return member;
    }
}
