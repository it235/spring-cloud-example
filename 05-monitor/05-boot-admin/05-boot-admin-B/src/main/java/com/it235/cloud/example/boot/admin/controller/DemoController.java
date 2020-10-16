package com.it235.cloud.example.boot.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/10/14 23:22
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("get")
    public String get(){
        return "ok";
    }
}
