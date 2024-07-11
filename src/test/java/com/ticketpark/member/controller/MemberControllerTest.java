package com.ticketpark.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketpark.member.controller.request.MemberJoinRequest;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.model.entity.MemberStatus;
import com.ticketpark.member.model.entity.Role;
import com.ticketpark.member.repository.MemberRepository;
import com.ticketpark.member.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
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

    @MockBean
    private MemberService memberService;

    @MockBean
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
    @DisplayName("회원가입 request 유효성 체크")
    void validateMemberJoinRequest() throws Exception {
        request.setId("");
        request.setPassword("");
        request.setRole(null);
        request.setEmail("abc@@.com");

        when(memberService.join(any())).thenReturn(mock(Member.class));
        mvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("회원가입")
    void joinMember() throws Exception {
        when(memberService.join(any())).thenReturn(mock(Member.class));
        mvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isOk());
    }


}
