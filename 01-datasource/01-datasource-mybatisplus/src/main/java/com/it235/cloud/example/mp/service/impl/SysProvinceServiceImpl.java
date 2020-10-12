package com.it235.cloud.example.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it235.cloud.example.mp.entity.SysProvince;
import com.it235.cloud.example.mp.mapper.SysProvinceMapper;
import com.it235.cloud.example.mp.service.SysProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @description: 接口处理类，需要继承ServiceImpl泛型类
 * @package: com.it235.cloud.example.mp.service.impl
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

    @Override
    public SysProvince getByIdXml(int id) {
        return baseMapper.getByIdXml(id);
    }

    @Override
    public List<SysProvince> getByMapXml(Map<String, Object> map) {
        return sysProvinceMapper.getByMapXml(map);
    }

    @Override
    public List<SysProvince> getByMapQueryWrapper(String provinceCode, String provinceName) {
        LambdaQueryWrapper<SysProvince> lqw = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(provinceCode)){
            lqw.eq(SysProvince::getProvinceCode, provinceCode);
        }
        if(!StringUtils.isEmpty(provinceName)){
            lqw.like(SysProvince::getProvinceName, provinceName);
        }
        List<SysProvince> sysProvinces = baseMapper.selectList(lqw);
        return sysProvinces;
    }

    @Override
    public IPage<SysProvince> pages(int page, int size, SysProvince condition) {
        IPage<SysProvince> pageObj = new Page<>(page, size);
        LambdaQueryWrapper<SysProvince> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SysProvince::getProvinceName,condition.getProvinceName());
        wrapper.orderByAsc(SysProvince::getProvinceCode);
        IPage<SysProvince> pageResult = baseMapper.selectPage(pageObj, wrapper);
        return pageResult;
    }
}
