package com.ticketpark.ticket.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketpark.ticket.member.controller.request.MemberJoinRequest;
import com.ticketpark.ticket.member.model.dto.MemberDto;
import com.ticketpark.ticket.member.model.entity.Member;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import com.ticketpark.ticket.member.model.entity.Role;
import com.ticketpark.ticket.member.repository.MemberRepository;
import com.ticketpark.ticket.member.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private MemberJoinRequest request;

    @BeforeEach
    void beforeEach() {
        //초기 데이터 셋팅
        request = new MemberJoinRequest();
        request.setId("idTest1");
        request.setRole(Role.USER);
        request.setPassword("1q2w3e4r");
        request.setEmail("aa@aa.com");
        request.setHp_no("01012345678");
        request.setUse_yn(MemberStatus.USE);
    }

    @Test
    void 회원가입() throws Exception {

        //TODO @MockBean 오류 왜 나는지 파악 필요함
        when(memberService.join(request.fromJoinRequest(request))).thenReturn(mock(Member.class));
        mvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isOk());
    }

    @AfterEach
    void afterEach() {
        //기존 데이터 제거
        //TODO @Mock이면 여기 제대로 실행 안됨
        memberRepository.deleteMember(request.getId());
    }
}
