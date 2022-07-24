package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
// @RibbonClient(name = "chatbook", configuration = RibbonConfiguration.class)
@RibbonClient(name = "chatbook")
public class RibbonController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/invoke")
    public String invokeCharbook() {

        return template.getForObject("http://chatbook/chatbook-application/chat", String.class);

    }

}