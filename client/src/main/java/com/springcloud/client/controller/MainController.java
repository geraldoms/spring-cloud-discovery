package com.springcloud.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplateBuilder templateBuilder;

    @GetMapping("/services")
    public String callService() {

        final RestTemplate restTemplate = templateBuilder.build();
        final InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service", false);
        final String baseUrl = instanceInfo.getHomePageUrl();

        ResponseEntity<String> response =
            restTemplate.exchange(baseUrl + "message", HttpMethod.GET, null, String.class);
        return response.getBody();
    }

}
