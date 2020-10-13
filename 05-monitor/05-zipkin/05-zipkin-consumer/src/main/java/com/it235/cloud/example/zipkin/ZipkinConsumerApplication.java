package com.it235.cloud.example.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @package: com.it235.cloud.example.zipkin
 * @author: jianjun.ren
 * @date: Created in 2020/10/13 22:03
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@SpringBootApplication
public class ZipkinConsumerApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZipkinConsumerApplication.class, args);
    }
}
