package com.it235.cloud.example.mp.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @package: com.it235.cloud.example.mp.props
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 16:52
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@Getter
@Setter
//若实现注册中心，此处可以动态刷新
//@RefreshScope
@ConfigurationProperties(prefix = "it235.tenant")
public class TenantProperties {
    /**
     * 是否开启租户模式
     */
    private Boolean enable = false;

    /**
     * 需要排除的多租户的表
     */
    private List<String> ignoreTables = Arrays.asList("sys_user", "sys_dict", "sys_depart",
            "sys_role", "sys_tenant", "sys_role_permission");

    /**
     * 多租户字段名称
     */
    private String column = "tenant_id";

    /**
     * 排除不进行租户隔离的sql
     * 样例全路径：com.it235.knife.sys.mapper.UserMapper.list
     */
    private List<String> ignoreSqls = new ArrayList<>();
}
