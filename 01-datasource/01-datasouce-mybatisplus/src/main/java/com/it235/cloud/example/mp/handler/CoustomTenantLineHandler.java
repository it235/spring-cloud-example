package com.it235.cloud.example.mp.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.it235.cloud.example.mp.props.TenantProperties;
import com.it235.cloud.example.mp.tl.TenantTreadLocal;
import lombok.AllArgsConstructor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.StringValue;
/**
 * @description:
 * @package: com.it235.cloud.example.mp.props
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 16:50
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@AllArgsConstructor
public class CoustomTenantLineHandler implements TenantLineHandler {

    private TenantProperties tenantProperties;

    /**
     * 获取租户ID
     * @return
     */
    @Override
    public Expression getTenantId() {
        String tenant = TenantTreadLocal.getTenantId();
        if (tenant != null) {
            return new StringValue(TenantTreadLocal.getTenantId());
        }
        return new NullValue();
    }

    /**
     * 租户ID字段名，可以在TenantProperties中修改
     * @return
     */
    @Override
    public String getTenantIdColumn() {
        return tenantProperties.getColumn();
    }

    /**
     * 过滤不需要根据租户隔离的表
     * 默认返回 false 表示所有表都需要拼多租户条件
     * 可以在TenantProperties中修改
     * @param tableName 表名
     */
    @Override
    public boolean ignoreTable(String tableName) {
        return tenantProperties.getIgnoreTables().stream().anyMatch(
                (t) -> t.equalsIgnoreCase(tableName));
    }
}
