package com.ticketpark.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketpark.member.controller.request.MemberJoinRequest;
import com.ticketpark.member.fixture.MemberFixture;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.repository.MemberRepository;
import com.ticketpark.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("회원가입 request 유효성 체크")
    void validateMemberJoinRequest() throws Exception {
        request = MemberFixture.getEmptyRequiredInputJoinRequest();

        when(memberService.join(any())).thenReturn(mock(Member.class));
        mvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("회원가입")
    void joinMember() throws Exception {
        request = MemberFixture.getJoinRequest();

        when(memberService.join(any())).thenReturn(mock(Member.class));
        mvc.perform(post("/api/member/join").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isOk());
    }


}
