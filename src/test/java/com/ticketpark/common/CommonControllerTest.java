package com.ticketpark.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class CommonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    protected void executeStatusOk(String apiUrl, Object request) throws Exception {
        mvc.perform(post(apiUrl).contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isOk());
    }

    protected void executeStatusBadRequest(String apiUrl, Object request) throws Exception {
        mvc.perform(post(apiUrl).contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(request))).andDo(print())
                .andExpect(status().isBadRequest());
    }

}


