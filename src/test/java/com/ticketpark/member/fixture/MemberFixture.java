package com.ticketpark.member.fixture;

import com.ticketpark.member.controller.request.MemberJoinRequest;
import com.ticketpark.member.model.dto.MemberDto;
import com.ticketpark.member.model.entity.MemberStatus;
import com.ticketpark.member.model.entity.Role;

public class MemberFixture {

    //정상 request
    public static MemberJoinRequest getJoinRequest() {
        return MemberJoinRequest.builder()
                .id("idTest")
                .role(Role.USER)
                .password("1q2w3e4r")
                .email("aa@aa.com")
                .hp_no("01012345678")
                .use_yn(MemberStatus.USE)
                .build();
    }

    //필수입력값 빈 값 처리한 request
    public static MemberJoinRequest getEmptyRequiredInputJoinRequest() {
        return MemberJoinRequest.builder()
                .id("")
                .password("")
                .email("")
                .hp_no("01012345678")
                .use_yn(MemberStatus.USE)
                .build();
    }

    //이메일 포맷 문제있는 request
    public static MemberJoinRequest getInvalidEmailJoinRequest() {
        return MemberJoinRequest.builder()
                .id("idTest")
                .password("1q2w3e4r")
                .email("invalid_Email_format_data")
                .hp_no("01012345678")
                .use_yn(MemberStatus.USE)
                .build();
    }

    public static MemberDto getMemberDto() {
        MemberJoinRequest request = MemberFixture.getJoinRequest();
        return request.fromJoinRequest(request);
    }
}
