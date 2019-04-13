package com.view.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: gaodw
 * @Date: 10:26 2018/8/9
 * @Desc: 定时打印日志的任务
 */
@Slf4j
@Component
public class PrintTask {

    @Scheduled(cron="10 * * * * *")
    public void print(){
        log.info(">>>>>打印当前时间："+System.currentTimeMillis());
    }
}
