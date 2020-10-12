package com.it235.cloud.example.mp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it235.cloud.example.mp.entity.SysProvince;
import com.it235.cloud.example.mp.service.SysProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.it235.cloud.example.mp
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
        SysProvince province2 = sysProvinceService.getByIdXml(id);
        return province1;
    }

    @GetMapping("/getByCondition")
    public List<SysProvince> getByCondition(String provinceCode , String provinceName){
        List<SysProvince> list1 = sysProvinceService.getByMapQueryWrapper(provinceCode, provinceName);
        Map<String,Object> map = new HashMap<>();
        map.put("provinceCode" , provinceCode);
        map.put("provinceName" , provinceName);
        List<SysProvince> list2 = sysProvinceService.getByMapXml(map);
        return list1;
    }

    @GetMapping("/page")
    public IPage<SysProvince> getByCondition(int page , int size){
        SysProvince sysProvince = new SysProvince();
        sysProvince.setProvinceName("湖南省");
        IPage<SysProvince> pages = sysProvinceService.pages(page, size, sysProvince);
        return pages;
    }


}
