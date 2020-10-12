package com.it235.cloud.example.mp.tl;

/**
 * @description: TTL中多租户传递
 * @package: com.it235.cloud.example.mp.tl
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 17:03
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
public class TenantTreadLocal {

    /**
     * 若需要支持缓存线程的组件情况下传递可集成阿里巴巴开源的ttl
     * TransmittableThreadLocal
     *
     */
    private static final ThreadLocal<String> THREAD_LOCAL_TENANT = new ThreadLocal<>();

    /**
     * TL 设置租户ID<br/>
     * <b>谨慎使用此方法,避免嵌套调用 </b>
     * @param tenantId 租户ID
     */
    public static void setTenantId(String tenantId) {
        THREAD_LOCAL_TENANT.set(tenantId);
    }

    /**
     * 获取TTL中的租户ID
     * @return String
     */
    public static String getTenantId() {
        return THREAD_LOCAL_TENANT.get();
    }

    /**
     * 清除tenantId
     */
    public static void clear() {
        THREAD_LOCAL_TENANT.remove();
    }
}