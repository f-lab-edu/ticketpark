package com.ticketpark.member.fixture;

import com.ticketpark.member.controller.request.MemberJoinRequest;
import com.ticketpark.member.model.dto.MemberDto;
import com.ticketpark.member.model.entity.MemberStatus;
import com.ticketpark.member.model.entity.Role;
import lombok.Data;

public class MemberFixture {

    public static MemberJoinRequest getJoinRequest() {
        MemberJoinRequest request = new MemberJoinRequest();

        request = new MemberJoinRequest();
        request.setId("idTest1");
        request.setRole(Role.USER);
        request.setPassword("1q2w3e4r");
        request.setEmail("aa@aa.com");
        request.setHp_no("01012345678");
        request.setUse_yn(MemberStatus.USE);

        return request;
    }

    public static MemberDto getMemberDto() {
        MemberJoinRequest request = MemberFixture.getJoinRequest();
        return request.fromJoinRequest(request);
    }
}
