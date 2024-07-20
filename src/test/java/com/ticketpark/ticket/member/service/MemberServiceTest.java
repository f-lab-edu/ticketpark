package com.ticketpark.ticket.member.service;

import com.ticketpark.ticket.exception.TicketParkException;
import com.ticketpark.ticket.member.model.dto.MemberDto;
import com.ticketpark.ticket.member.model.entity.Member;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import com.ticketpark.ticket.member.model.entity.Role;
import com.ticketpark.ticket.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private MemberDto dto;

    @BeforeEach
    void beforeEach() {
        //테스트 데이터 셋팅
        dto = new MemberDto();
        dto.setId("idTest2");
        dto.setRole(Role.USER);
        dto.setPassword("1q2w3e4r");
        dto.setEmail("aa@aa.com");
        dto.setHp_no("01012345678");
        dto.setUse_yn(MemberStatus.USE);
    }

    @Test
    void 회원가입_정상_동작(){
        //when
        Member joinedMember = memberService.join(dto);
        Member searchedMember = memberRepository.findById(dto.getId()).orElseGet(Member::new);
        //then
        assertThat(joinedMember.getId()).isEqualTo(searchedMember.getId());
    }

    @Test
    void 회원가입시_아이디중복되면_에러발생(){
        //동일 아이디로 2번 가입 시 exception 발생
        Member join = memberService.join(dto);
        assertThrows(TicketParkException.class, () -> memberService.join(dto));

    }

    @AfterEach
    void afterEach() {
        //기존 데이터 제거
        memberRepository.deleteMember(dto.getId());
    }

}
