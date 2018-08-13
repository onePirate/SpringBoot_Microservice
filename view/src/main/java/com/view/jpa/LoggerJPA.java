package com.view.jpa;

import com.view.entity.jpa.LoggerBo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: gwx556610
 * @Date: 16:20 2018/8/8
 * @Desc: Logger日志记录的jpa
 */
public interface LoggerJPA extends JpaRepository<LoggerBo,Long> {
}
