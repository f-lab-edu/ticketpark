package com.ticketpark.ticket.member.service;

import com.ticketpark.ticket.exception.ErrorCode;
import com.ticketpark.ticket.exception.TicketParkException;
import com.ticketpark.ticket.member.model.dto.MemberDto;
import com.ticketpark.ticket.member.model.entity.Member;
import com.ticketpark.ticket.member.repository.IMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final IMemberRepository memberRepository;

    @Transactional
    public MemberDto join(MemberDto memberDto) {

        //아이디 중복 체크
        memberRepository.findById(memberDto.getId()).ifPresent(m -> {
            throw new TicketParkException(ErrorCode.DUPLICATED_ID, String.format("중복 아이디 : ", memberDto.getId()));
        });

        //회원가입
        Member joinMember = memberRepository.addMember(Member.of(memberDto));
        return MemberDto.fromEntity(joinMember);
    }
}
