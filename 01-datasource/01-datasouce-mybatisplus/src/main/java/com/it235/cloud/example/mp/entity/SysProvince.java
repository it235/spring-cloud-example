package com.it235.cloud.example.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: bs_provice数据库实体类
 * @package: com.it235.cloud.example.mp.entity
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 16:04
 * @copyright: Copyright (c) 2020
 * @modified: jianjun.ren
 */
@Data
public class SysProvince implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 省份代码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 排序
     */
    private Integer sort;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Integer delFlag;

    private String deleteBy;

    private Date deleteTime;
}
