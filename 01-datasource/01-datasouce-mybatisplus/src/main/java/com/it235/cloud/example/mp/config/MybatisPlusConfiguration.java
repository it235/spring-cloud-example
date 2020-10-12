package com.it235.cloud.example.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.it235.cloud.example.mp.handler.AutoFullTimeHandler;
import com.it235.cloud.example.mp.handler.CoustomTenantLineHandler;
import com.it235.cloud.example.mp.props.TenantProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @package: com.it235.cloud.example.mp
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 16:46
 * @copyright: Copyright (c) 2019
 * @modified: jianjun.ren
 */
@Configuration
@MapperScan("com.it235.cloud.example.*.mapper")
@EnableConfigurationProperties(TenantProperties.class)
@EnableTransactionManagement
public class MybatisPlusConfiguration {
    @Autowired
    private TenantProperties tenantProperties;

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        //多租户开启
        if(tenantProperties.getEnable()){
            interceptor.addInnerInterceptor(
                    new TenantLineInnerInterceptor(
                            new CoustomTenantLineHandler(tenantProperties)));
        }
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

    @Bean
    @ConditionalOnMissingBean(AutoFullTimeHandler.class)
    public AutoFullTimeHandler mateMetaObjectHandler(){
        AutoFullTimeHandler autoFullTimeHandler = new AutoFullTimeHandler();
//        log.info("AutoFullTimeHandler [{}]", autoFullTimeHandler);
        return autoFullTimeHandler;
    }
}
