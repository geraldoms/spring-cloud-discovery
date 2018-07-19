package com.springcloud.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${service.instance.name}")
    private String instance;

    @GetMapping("/message")
    public String message(){
        return "This is the: " + instance;
    }
}
