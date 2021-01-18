package com.demo.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class ControllerCalculatorTest {
    @Autowired private MockMvc mockMvc;
    @Test
    void getPlus() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/rest/plus")
        .param("a", "1.2")
        .param("b","1.2")).andReturn();
        String content = result.getResponse().getContentAsString();

        assertEquals(content, "2.4");
    }

    @Test
    void getMinus() throws Exception {
        this.mockMvc.perform(get("/rest/minus")
                .param("a", "1.2")
                .param("b","1.2")).andExpect(status().isOk());
    }

    @Test
    void getDivide() throws Exception {
        this.mockMvc.perform(get("/rest/divide")
                .param("a", "1.2")
                .param("b","1.2")).andExpect(status().isOk());
    }

    @Test
    void getTimes() throws Exception {
        this.mockMvc.perform(get("/rest/times")
                .param("a", "1.2")
                .param("b","1.2")).andExpect(status().isOk());
    }

    @Test
    void getMod() throws Exception {
        this.mockMvc.perform(get("/rest/mod")
                .param("a", "3")
                .param("b","2")).andExpect(status().isOk());
    }


    @Test
    void getModMinus() throws Exception {
        this.mockMvc.perform(get("/rest/mod")
                .param("a", "3")
                .param("b","-2")).andExpect(status().isOk());
    }

}