package com.springcloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/services")
    public String callService() {

        return restTemplate.getForEntity("http://service/message", String.class)
                           .getBody();

    }

}
