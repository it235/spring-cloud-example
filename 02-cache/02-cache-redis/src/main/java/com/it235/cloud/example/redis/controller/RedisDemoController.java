package com.it235.cloud.example.redis.controller;

import com.it235.cloud.example.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: redis接口测试类
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 23:23
 */
@RestController
@RequestMapping("/redis")
public class RedisDemoController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("test")
    public String test(String key){
        Boolean flag = redisUtil.set(key, "redis测试");
        if(flag){
            return (String) redisUtil.get(key);
        }
        return "失败";
    }
}
