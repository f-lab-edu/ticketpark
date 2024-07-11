package com.ticketpark.member.controller;

import com.ticketpark.common.response.Response;
import com.ticketpark.member.controller.request.MemberJoinRequest;
import com.ticketpark.member.controller.response.MemberJoinResponse;
import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public Response<MemberJoinResponse> join(@RequestBody @Valid MemberJoinRequest request){
        Member member = memberService.join(request.fromJoinRequest(request));
        return Response.success(MemberJoinResponse.fromMember(member));
    }

}
