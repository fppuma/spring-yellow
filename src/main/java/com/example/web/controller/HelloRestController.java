package com.example.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.json.Greeting;

@RestController
public class HelloRestController {
  @GetMapping("rest")
  public Greeting greet(@RequestParam(defaultValue = "World") String name) {
    return new Greeting("Hello, " + name + "!");
  }
}
