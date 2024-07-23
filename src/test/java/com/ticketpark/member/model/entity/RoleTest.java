package com.ticketpark.member.model.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class RoleTest {

    private ObjectMapper mapper;

    @DisplayName("잘못된 enum Role 데이터 파싱하는 경우")
    @Test
    void inValidRoleEnumData() throws IOException {
        //given
        mapper = new ObjectMapper();
        String jsonString = "invalid_enum_role_data";

        //when
        Role role = mapper.readValue(mapper.writeValueAsBytes(jsonString), Role.class);

        //then
        assertThat(role).isNull();
    }

    @DisplayName("올바른 enum Role 데이터 파싱하는 경우")
    @Test
    void correctRoleEnumData() throws IOException {
        //given
        mapper = new ObjectMapper();
        String jsonString = "U";

        //when
        Role role = mapper.readValue(mapper.writeValueAsBytes(jsonString), Role.class);

        //then
        assertThat(role).isNotNull();
    }


}