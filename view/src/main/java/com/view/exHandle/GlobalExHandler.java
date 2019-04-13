package com.view.exHandle;

import com.common.entity.Result;
import com.common.tools.ResultTool;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: gaodw
 * @Date: 17:29 2018/8/8
 * @Desc: 全局异常处理
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class GlobalExHandler {

    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @ControllerAdvice的annotations属性值为RestController.class，也就是只有添加了@RestController注解的控制器才会进入全局异常处理
     * @ExceptionHandler注解用来配置需要拦截的异常类型，默认是全局类型。
     * @ResponseStatus注解用于配置遇到该异常后返回数据时的StatusCode的值，我们这里默认使用值500。
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public Result runtimeExceptionHandler(Exception e) {
        return ResultTool.failed();
    }
}
