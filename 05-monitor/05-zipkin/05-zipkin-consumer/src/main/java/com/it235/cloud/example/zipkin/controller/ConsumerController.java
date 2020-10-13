package com.it235.cloud.example.zipkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @package: com.it235.cloud.example.zipkin.controller
 * @author: jianjun.ren
 * @date: Created in 2020/10/13 22:04
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String test(){
        String result = restTemplate.getForObject("http://localhost:7050/province/get/1", String.class);
        return result;
    }
}
