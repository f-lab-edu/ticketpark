package com.ticketpark.ticket.member.controller.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketpark.ticket.member.model.entity.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class MemberJoinRequestTest {

    @Autowired
    private Validator validator;

    @Autowired
    private ObjectMapper mapper;

    private MemberJoinRequest request;

    @BeforeEach
    void beforeEach() {
        request = new MemberJoinRequest();
        request.setId("id");
        request.setPassword("1q2w3e4r");
        request.setEmail("abc@abc.com");
    }


    @DisplayName("회원가입 필수입력 항목 검증(아이디, 패스워드, 이메일)")
    @Test
    void checkRequiredInput() {
        //given
        request.setId("");
        request.setPassword("");
        request.setEmail("");

        //when
        List<String> validateMessage = this.getValidateMessage(request);

        //then
        assertThat(validateMessage).contains("아이디는 입력하세요", "비밀번호는 입력하세요", "이메일을 입력하세요");
    }

    @DisplayName("회원가입 이메일 포맷 확인")
    @Test
    void checkEmailFormat(){
        //given
        request.setEmail("abcd@");

        //when
        List<String> validateMessage = this.getValidateMessage(request);

        //then
        assertThat(validateMessage).contains("이메일 형식이 맞지 않습니다");
    }
    
    @DisplayName("enum 값 유효성 체크")
    @Test
    void checkEnumValue() throws JsonProcessingException {
        //given
        String enumValue = "test";
        //when
        Role memberRole = Role.from(enumValue);
        //then
        assertThat(memberRole).isNull();
    }
    
    
    //유효성 위반 메시지 리턴
    private List<String> getValidateMessage(MemberJoinRequest request){
        Set<ConstraintViolation<MemberJoinRequest>> validate = validator.validate(request);

        Iterator<ConstraintViolation<MemberJoinRequest>> iterator = validate.iterator();
        List<String> messages = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<MemberJoinRequest> next = iterator.next();
            messages.add(next.getMessage());
        }
        return messages;
    }



}