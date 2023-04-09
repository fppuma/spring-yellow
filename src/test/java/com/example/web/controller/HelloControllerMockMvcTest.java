package com.example.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(HelloController.class)
public class HelloControllerMockMvcTest {
  @Autowired
  private MockMvc mvc;

  @Test
  public void testHelloWithoutName() throws Exception {
    mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
        .andExpect(status().isOk())
        .andExpect(view().name("welcome"))
        .andExpect(model().attribute("user", "World"));

  }

  @Test
  public void testHelloWithName() throws Exception {
    mvc.perform(get("/hello").param("name", "Dolly").accept(MediaType.TEXT_HTML))
        .andExpect(status().isOk())
        .andExpect(view().name("welcome"))
        .andExpect(model().attribute("user", "Dolly"));
  }

  @Test
  public void testHelloWithNameUrl() throws Exception {
    mvc.perform(get("/hello?name={name}","Frank").accept(MediaType.TEXT_HTML))
        .andExpect(status().isOk())
        .andExpect(view().name("welcome"))
        .andExpect(model().attribute("user", "Frank"));
  }
}
