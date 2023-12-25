package com.springstarter.springstarterweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/test")
    public String helloRest() {
        return "simple method 1234578";
    }
}
