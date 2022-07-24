package com.project.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    IClientConfig ribbonClient;

    @Bean
    public IPing ribbonPing(IClientConfig config) {

        return new PingUrl();

    }

//    // For some reason, the presence of this method causes problems
//    // with the application being able to find the chatbook applications.
//    @Bean
//    public IRule ribbonRule(IClientConfig config) {
//
//        return new AvailabilityFilteringRule();
//
//    }

}