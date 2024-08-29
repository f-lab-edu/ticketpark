package com.ticketpark.member.service;

import com.ticketpark.exception.TicketParkException;
import com.ticketpark.member.fixture.MemberFixture;
import com.ticketpark.member.model.dto.MemberDto;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.model.entity.MemberStatus;
import com.ticketpark.member.model.entity.Role;
import com.ticketpark.member.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private MemberDto dto;

    @BeforeEach
    void beforeEach() {
        dto = MemberFixture.getMemberDto();
    }

    @DisplayName("회원가입 정상 동작")
    @Test
    void joinMember(){
        //when
        Member joinedMember = memberService.join(dto);
        Member searchedMember = memberRepository.findById(dto.getId()).orElseGet(Member::new);
        //then
        assertThat(joinedMember.getId()).isEqualTo(searchedMember.getId());
    }

    @DisplayName("회원가입 시 아이디 중복되면 에러 발생")
    @Test
    void joinErrorByDuplicatedId(){
        //동일 아이디로 2번 가입 시 exception 발생
        Member join = memberService.join(dto);
        assertThrows(TicketParkException.class, () -> memberService.join(dto));

    }
}
