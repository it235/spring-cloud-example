package com.it235.cloud.example.zipkin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it235.cloud.example.zipkin.entity.SysProvince;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.it235.cloud.example.zipkin.service
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 12:15
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
public interface SysProvinceService extends IService<SysProvince> {

    /**
     * MyBatis注解方式查询
     * @param id
     * @return
     */
    SysProvince getByIdAnnotation(int id);
}
