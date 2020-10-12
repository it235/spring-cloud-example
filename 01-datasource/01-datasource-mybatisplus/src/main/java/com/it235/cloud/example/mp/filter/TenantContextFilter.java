package com.it235.cloud.example.mp.filter;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.it235.cloud.example.mp.props.TenantProperties;
import com.it235.cloud.example.mp.tl.TenantTreadLocal;
import lombok.SneakyThrows;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 租户拦截器，请求过来时进行拦截
 * @author: jianjun.ren
 * @date: Created in 2020/10/12 22:41
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TenantContextFilter extends GenericFilterBean {

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            //优先取请求参数中的tenantId值
            String tenantId = request.getParameter(TenantProperties.TENANT_ID_PARAM_PROP);
            if (StringUtils.isBlank(tenantId)) {
                tenantId = request.getHeader(TenantProperties.TENANT_ID_HEADER_PROP);
            }
            System.out.println("获取到的租户ID为：" + tenantId);
            if (StringUtils.isNotBlank(tenantId)) {
                TenantTreadLocal.setTenantId(tenantId);
            } else {
                if (StringUtils.isBlank(TenantTreadLocal.getTenantId())) {
                    TenantTreadLocal.setTenantId(TenantProperties.DEFAULT_TENANT_ID);
                }
            }
            filterChain.doFilter(request, response);
        } finally {
            TenantTreadLocal.clear();
        }
    }
}
