package com.junseok.api.demo.controller;

import com.junseok.api.demo.service.DemoService;
import com.junseok.api.demo.vo.DemoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMybatis
@WebMvcTest(DemoController.class)
class DemoControllerTest {

    @Autowired
    public MockMvc mockMvc;
    @MockBean
    public DemoService demoService;

    private static final String BASE_URL = "/api/demo";

    @Test
    void demoTest() throws Exception {

        final ObjectMapper objectMapper = new ObjectMapper();
        final String valueAsString = objectMapper.writeValueAsString(
                new DemoRequest("demo")
        );

        mockMvc.perform(post(BASE_URL)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .content(valueAsString))
                .andDo(print())
                .andExpect(status().isOk());
    }


}