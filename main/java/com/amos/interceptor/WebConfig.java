package com.amos.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Amos
 * @date 2020-10-28 20:49
 * 拦截/admin/**
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    public  void addInterceptors(InterceptorRegistration registration)
    {
        registration.addPathPatterns("/admin/**");
        registration.excludePathPatterns("/admin","/admin/login");
    }
}
