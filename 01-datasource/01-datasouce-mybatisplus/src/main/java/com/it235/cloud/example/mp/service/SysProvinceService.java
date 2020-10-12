package com.it235.cloud.example.mp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it235.cloud.example.mp.entity.SysProvince;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.it235.cloud.example.mp.service
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

    /**
     * XML单条件方式查询
     * @param id
     * @return
     */
    SysProvince getByIdXml(int id);

    /**
     * XML多条件方式查询
     * @param map
     * @return
     */
    List<SysProvince> getByMapXml(Map<String,Object> map);

    /**
     * MyBatisPlus对象方式查询
     * @param provinceCode
     * @param provinceName
     * @return
     */
    List<SysProvince> getByMapQueryWrapper(String provinceCode , String provinceName);

    /**
     * 分页查询，使用MyBatisplus内置的IPage对象即可
     * @param page
     * @param size
     * @return
     */
    IPage<SysProvince> pages(int page , int size, SysProvince condition);
}
