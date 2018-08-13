package com.common.tools;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: gwx556610
 * @Date: 17:13 2018/8/8
 * @Desc:
 */
public class SpringFactoryTool {

    /**
     * 根据传入的类型获取spring管理的对应Bean
     * @param clazz 类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz,HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
