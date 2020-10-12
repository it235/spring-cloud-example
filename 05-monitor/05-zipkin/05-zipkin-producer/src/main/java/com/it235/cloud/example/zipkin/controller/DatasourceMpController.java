package com.it235.cloud.example.zipkin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it235.cloud.example.redis.util.RedisUtil;
import com.it235.cloud.example.zipkin.entity.SysProvince;
import com.it235.cloud.example.zipkin.service.SysProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 功能使用详见 DBMybatisplusApplicationTests
 * @package: com.it235.cloud.example.zipkin
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 12:13
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@RestController
@RequestMapping("/province")
public class DatasourceMpController {

    @Autowired
    private SysProvinceService sysProvinceService;

    @GetMapping("/get/{id}")
    public SysProvince getById(@PathVariable("id") int id){
        SysProvince province1 = sysProvinceService.getByIdAnnotation(id);
        return province1;
    }

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
