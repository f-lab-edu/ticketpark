package com.ticketpark.ticket.member.model.dto;

import com.ticketpark.ticket.member.model.entity.Member;
import com.ticketpark.ticket.member.model.entity.Role;
import com.ticketpark.ticket.member.model.entity.MemberStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String id;
    private Role role;
    private String password;
    private String email;
    private String hp_no;
    private Timestamp created_dt;
    private Timestamp updated_dt;
    private MemberStatus use_yn;

    public static MemberDto fromEntity(Member entity) {
        return new MemberDto(
                entity.getId(),
                entity.getRole(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getHp_no(),
                entity.getCreated_dt(),
                entity.getUpdated_dt(),
                entity.getUse_yn()
        );
    }
}
