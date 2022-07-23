package com.project.springcloudribbonjt2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "chatbook", configuration = RibbonConfiguration.class)
public class SpringCloudRibbonJt2Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudRibbonJt2Application.class, args);

    }

    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }

}