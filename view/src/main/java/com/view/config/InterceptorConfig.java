package com.view.config;

import com.view.interceptor.LoggerInterceptor;
import com.view.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: gaodw
 * @Date: 10:27 2018/7/24
 * @Desc: 拦截器的使用
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }

}
