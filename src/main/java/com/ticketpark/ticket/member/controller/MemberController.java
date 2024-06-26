package com.ticketpark.ticket.member.controller;

import com.sun.net.httpserver.Authenticator;
import com.ticketpark.ticket.common.response.Response;
import com.ticketpark.ticket.member.controller.request.MemberJoinRequest;
import com.ticketpark.ticket.member.controller.response.MemberJoinResponse;
import com.ticketpark.ticket.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public Response<MemberJoinResponse> join(@RequestBody MemberJoinRequest request){
        return Response.success(MemberJoinResponse.fromMemberDto(memberService.join(request.fromJoinRequest(request))));
    }

}
