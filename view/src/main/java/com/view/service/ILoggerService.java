package com.view.service;

import com.view.entity.jpa.LoggerBo;

/**
 * @Author: gwx556610
 * @Date: 16:27 2018/8/8
 * @Desc:
 */
public interface ILoggerService {

    LoggerBo saveOrUpdate(LoggerBo logBo);
}
