package com.ticketpark.member.controller;

import com.ticketpark.common.CommonControllerTest;
import com.ticketpark.member.controller.request.MemberJoinRequest;
import com.ticketpark.member.fixture.MemberFixture;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemberControllerTest extends CommonControllerTest {

    @MockBean
    private MemberService memberService;

    private MemberJoinRequest request;

    @Test
    @DisplayName("회원가입 request 유효성 체크")
    void validateMemberJoinRequest() throws Exception {
        //given
        request = MemberFixture.getEmptyRequiredInputJoinRequest();
        //when
        when(memberService.join(any())).thenReturn(mock(Member.class));
        //then
        this.executeStatusBadRequest("/api/member/join", request);
    }

    @Test
    @DisplayName("회원가입")
    void joinMember() throws Exception {
        //given
        request = MemberFixture.getJoinRequest();
        //when
        when(memberService.join(any())).thenReturn(mock(Member.class));
        //then
        this.executeStatusOk("/api/member/join", request);
    }

}
