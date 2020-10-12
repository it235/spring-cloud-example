package com.it235.cloud.example.zipkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it235.cloud.example.zipkin.entity.SysProvince;
import com.it235.cloud.example.zipkin.mapper.SysProvinceMapper;
import com.it235.cloud.example.zipkin.service.SysProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @description: 接口处理类，需要继承ServiceImpl泛型类
 * @package: com.it235.cloud.example.zipkin.service.impl
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 16:19
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@Service
public class SysProvinceServiceImpl extends ServiceImpl<SysProvinceMapper, SysProvince> implements SysProvinceService {

    @Autowired
    private SysProvinceMapper sysProvinceMapper;

    @Override
    public SysProvince getByIdAnnotation(int id) {
        return sysProvinceMapper.getByIdAnnotation(id);
    }

}
