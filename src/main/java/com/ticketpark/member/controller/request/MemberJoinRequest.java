package com.ticketpark.member.controller.request;

import com.ticketpark.member.model.dto.MemberDto;
import com.ticketpark.member.model.entity.Role;
import com.ticketpark.member.model.entity.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinRequest {
    @NotBlank(message = "아이디는 입력하세요")
    private String id;
    private Role role;
    @NotBlank(message = "비밀번호는 입력하세요")
    private String password;
    @Email(message = "이메일 형식이 맞지 않습니다")
    @NotBlank(message = "이메일을 입력하세요")
    private String email;
    private String hp_no;
    private LocalDateTime created_dt;
    private LocalDateTime updated_dt;
    private MemberStatus use_yn;

    public MemberDto fromJoinRequest(MemberJoinRequest request){
        return new MemberDto(
                request.getId(),
                request.getRole(),
                request.getPassword(),
                request.getEmail(),
                request.getHp_no(),
                LocalDateTime.now(),
                request.getUpdated_dt() == null ? LocalDateTime.now() : request.getUpdated_dt(),
                request.getUse_yn()
        );
    }
}
