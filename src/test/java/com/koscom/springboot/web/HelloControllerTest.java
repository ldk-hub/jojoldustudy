package com.koscom.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.net.URI;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) //(1)
@WebMvcTest //(2)
public class HelloControllerTest {
    @Autowired // (3)
    private MockMvc mvc; //(4)



    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // (5)
                .andExpect(status().isOk()) // (6)
                .andExpect(content().string(hello)); // (7)
    }
    //정상처리케이스
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name) // (1)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // (2)
                .andExpect(jsonPath("$.amount", is(amount)));
    }

    //예외발생시처리
    @Test
    void amount가없으면_응답코드가400이_된다() throws Exception {
        String name = "hello";

        mvc.perform(get("/hello/dto")
                        .param("name", name))
                .andExpect(status().isBadRequest());
    }
}