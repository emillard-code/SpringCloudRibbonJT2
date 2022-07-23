package com.project.springcloudribbonjt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "chatbook") // @RibbonClient(name = "chatbook", configuration = RibbonConfiguration.class)
public class SpringCloudRibbonJt2Application {

    @Autowired
    private RestTemplate template;

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudRibbonJt2Application.class, args);

    }

    @GetMapping("/invoke")
    public String invokeCharbook() {

        return template.getForObject("http://chatbook/chatbook-application/chat" , String.class);

    }

    @Bean
    @LoadBalanced
    public RestTemplate template() {

        return new RestTemplate();

    }

}