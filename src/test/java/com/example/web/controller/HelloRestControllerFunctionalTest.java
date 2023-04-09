package com.example.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.web.json.Greeting;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerFunctionalTest {
  
  @Test
  public void greetObjectTest(@Autowired TestRestTemplate template) {
    Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
    assertEquals("Hello, Dolly!", response.message());

  }

  @Test
  public void greetEntityTest(@Autowired TestRestTemplate template) {
    ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
    Greeting response = entity.getBody();
    if (response != null) {
        assertEquals("Hello, World!", response.message());
    }
  }
}
