package com.ticketpark.member.model.dto;

import com.ticketpark.member.model.entity.Member;
import com.ticketpark.member.model.entity.Role;
import com.ticketpark.member.model.entity.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MemberDto {
    private String id;
    private Role role;
    private String password;
    private String email;
    private String hp_no;
    private LocalDateTime created_dt;
    private LocalDateTime updated_dt;
    private MemberStatus use_yn;
}
