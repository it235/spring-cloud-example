package com.it235.cloud.example;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/10/14 23:46
 */
@SpringBootApplication
@EnableAdminServer
public class BootAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAdminServerApplication.class , args);
    }
}
