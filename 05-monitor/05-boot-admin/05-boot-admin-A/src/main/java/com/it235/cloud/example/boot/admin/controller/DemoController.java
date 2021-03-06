package com.it235.cloud.example.boot.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: jianjun.ren
 * @date: Created in 2020/10/14 23:22
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("get")
    public String get(){
        log.info("这里是新日志，日志XXX:{}" , "abc");
        int i = 0;
        int x = 3 / i;
        return "ok";
    }
}
