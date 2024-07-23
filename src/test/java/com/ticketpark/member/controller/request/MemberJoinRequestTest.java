package com.ticketpark.member.controller.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketpark.member.fixture.MemberFixture;
import com.ticketpark.member.model.entity.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberJoinRequestTest {

    @Autowired
    private Validator validator;

    @Autowired
    private ObjectMapper mapper;

    private MemberJoinRequest request;

    @DisplayName("회원가입 필수입력 항목 검증(아이디, 패스워드, 이메일)")
    @Test
    void checkRequiredInput() {
        //given
        request = MemberFixture.getEmptyRequiredInputJoinRequest();

        //when
        List<String> validateMessage = this.getValidateMessage(request);

        //then
        assertThat(validateMessage).containsExactlyInAnyOrder("아이디는 입력하세요", "비밀번호는 입력하세요", "이메일을 입력하세요");
    }

    @DisplayName("회원가입 이메일 포맷 확인")
    @Test
    void checkEmailFormat(){
        //given
        request = MemberFixture.getInvalidEmailJoinRequest();

        //when
        List<String> validateMessage = this.getValidateMessage(request);

        //then
        assertThat(validateMessage).containsExactly("이메일 형식이 맞지 않습니다");
    }

    //유효성 위반 메시지 리턴
    private List<String> getValidateMessage(MemberJoinRequest request){
        return validator.validate(request).stream()
                .map(ConstraintViolation::getMessage)
                .toList();
    }

}