package com.it235.cloud.example.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it235.cloud.example.mp.entity.SysProvince;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description: Mapper接口类
 * @package: com.it235.cloud.example.mp.mapper
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 16:06
 * @copyright: Copyright (c) 2020
 * @modified: jianjun.ren
 */
@Mapper
@Repository
public interface SysProvinceMapper extends BaseMapper<SysProvince> {

    /**
     * 注解方式的查询
     * @param id
     * @return
     */
    @Select("select * from sys_province where id = #{id}")
    SysProvince getByIdAnnotation(@Param("id") int id);

    /**
     * XML方式的查询
     * @param id
     * @return
     */
    SysProvince getByIdXml(int id);

    /**
     * 复杂参数的XML查询
     * @param map
     * @return
     */
    List<SysProvince> getByMapXml(Map<String,Object> map);
}
