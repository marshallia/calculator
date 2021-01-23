package com.demo.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = DemoApplication.class)
public class BookTest {
    @Autowired
    private MockMvc mockMvc;

//    actually you should test return value of the API.
//    But since it is only integration testing we don't need it.

    @Test
    @Order(1)
    void getList_should_return_empty_array() throws Exception {
        this.mockMvc.perform(get("/rest/bookList")).andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void insert_should_return_book() throws Exception {
        this.mockMvc.perform(get("/rest/insertBook")
                .param("Author", "A")
                .param("Title", "Title A"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void getList_should_return_array() throws Exception {
        this.mockMvc.perform(get("/rest/bookList")).andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void edit_should_return_book() throws Exception {
        this.mockMvc.perform(get("/rest/edit")
                .param("Author", "A")
                .param("Title", "Title A")
                .param("ID", "1"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void edit_should_return_failed() throws Exception {
        this.mockMvc.perform(get("/rest/edit")
                .param("Author", "A")
                .param("Title", "Title A")
                .param("ID", "2"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @Order(5)
    void delete_should_return_success() throws Exception {
        this.mockMvc.perform(get("/rest/delete")
                .param("ID", "1"))
                .andExpect(status().isOk());
    }
   @Test
    @Order(5)
    void delete_should_return_failed() throws Exception {
        this.mockMvc.perform(get("/rest/delete")
                .param("ID", "12"))
                .andExpect(status().is4xxClientError());
    }
    @Test
    @Order(6)
    void getPlus() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/rest/plus")
                .param("a", "1.2")
                .param("b","1.2")).andReturn();
        String content = result.getResponse().getContentAsString();

        assertEquals(content, "2.4");
    }

    @Test
    @Order(7)
    void getMinus() throws Exception {
        this.mockMvc.perform(get("/rest/minus")
                .param("a", "1.2")
                .param("b","1.2")).andExpect(status().isOk());
    }

    @Test
    @Order(8)
    void getDivide() throws Exception {
        this.mockMvc.perform(get("/rest/divide")
                .param("a", "1.2")
                .param("b","1.2")).andExpect(status().isOk());
    }

    @Test
    @Order(8)
    void getDivide_return_div_by_null() throws Exception {
        this.mockMvc.perform(get("/rest/divide")
                .param("a", "1.2")
                .param("b","0")).andExpect(status().is4xxClientError());
    }

    @Test
    @Order(9)
    void getTimes() throws Exception {
        this.mockMvc.perform(get("/rest/times")
                .param("a", "1.2")
                .param("b","1.2")).andExpect(status().isOk());
    }

    @Test
    @Order(10)
    void getMod() throws Exception {
        this.mockMvc.perform(get("/rest/mod")
                .param("a", "3")
                .param("b","2")).andExpect(status().isOk());
    }
   @Test
    @Order(10)
    void getMod_should_failed() throws Exception {
        this.mockMvc.perform(get("/rest/mod")
                .param("a", "3")
                .param("b","0")).andExpect(status().is4xxClientError());
    }


    @Test
    @Order(11)
    void getModMinus() throws Exception {
        this.mockMvc.perform(get("/rest/mod")
                .param("a", "3")
                .param("b","-2")).andExpect(status().isOk());
    }
}
