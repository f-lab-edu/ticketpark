package com.ticketpark.ticket.member.controller.request;

import com.ticketpark.ticket.member.model.dto.MemberDto;
import com.ticketpark.ticket.member.model.entity.Role;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

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
    private Timestamp created_dt;
    private Timestamp updated_dt;
    private MemberStatus use_yn;

    public MemberDto fromJoinRequest(MemberJoinRequest request){
        return new MemberDto(
                request.getId(),
                request.getRole(),
                request.getPassword(),
                request.getEmail(),
                request.getHp_no(),
                request.getCreated_dt() == null ? Timestamp.from(Instant.now()) : request.getCreated_dt(),
                request.getUpdated_dt() == null ? Timestamp.from(Instant.now()) : request.getUpdated_dt(),
                request.getUse_yn()
        );
    }
}
