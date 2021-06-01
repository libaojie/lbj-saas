package com.lbj.saas;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2021/6/1 16:14
 * @File Config
 * @Version v1.0
 * @Date 2021/2/5 14:56
 * @Created by libaojie
 */
@Configuration
public class Config {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
