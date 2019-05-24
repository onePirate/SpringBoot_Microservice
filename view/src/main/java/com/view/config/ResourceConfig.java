package com.view.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: gaodw
 * @Date: 16:44 2018/8/8
 * @Desc: 自定义资源文件夹，避免暴露实际资源放置的文件夹给客户
 */
@Configuration
public class ResourceConfig  extends WebMvcConfigurerAdapter {

    //自定义静态资源文件路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/define/resource/**").addResourceLocations("classpath:/static/");
    }
}
