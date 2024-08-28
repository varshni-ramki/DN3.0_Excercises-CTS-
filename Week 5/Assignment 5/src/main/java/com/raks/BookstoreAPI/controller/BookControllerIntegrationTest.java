package com.raks.BookstoreAPI.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateBook() throws Exception {
        mockMvc.perform(post("/books")
                .contentType("application/json")
                .content("{\"title\":\"Book Title\", \"author\":\"Author Name\", \"price\":29.99, \"isbn\":\"12345\"}"))
               .andExpect(status().isCreated());
    }

    // More integration tests for GET, PUT, DELETE
}
