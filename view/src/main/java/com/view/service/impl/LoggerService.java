package com.view.service.impl;

import com.view.jpa.LoggerJPA;
import com.view.entity.jpa.LoggerBo;
import com.view.service.ILoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: gwx556610
 * @Date: 16:27 2018/8/8
 * @Desc: 日志接口实现类
 */
@Service
public class LoggerService implements ILoggerService {

    @Autowired
    LoggerJPA logJpa;

    @Override
    public LoggerBo saveOrUpdate(LoggerBo logBo) {
        return logJpa.save(logBo);
    }
}
