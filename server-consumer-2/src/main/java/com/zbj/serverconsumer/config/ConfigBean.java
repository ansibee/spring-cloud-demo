package com.zbj.serverconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 采用随机负载均衡
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
