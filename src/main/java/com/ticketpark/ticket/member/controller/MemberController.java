package com.ticketpark.ticket.member.controller;

import com.ticketpark.ticket.common.response.Response;
import com.ticketpark.ticket.member.controller.request.MemberJoinRequest;
import com.ticketpark.ticket.member.controller.response.MemberJoinResponse;
import com.ticketpark.ticket.member.model.entity.Member;
import com.ticketpark.ticket.member.service.MemberService;
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
