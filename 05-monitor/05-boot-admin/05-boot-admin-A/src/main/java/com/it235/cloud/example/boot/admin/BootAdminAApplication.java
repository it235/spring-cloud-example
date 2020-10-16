package com.it235.cloud.example.boot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/10/14 23:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BootAdminAApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootAdminAApplication.class , args);
    }
}
