package com.spark.controller;

import com.spark.service.SparkFirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: gwx556610
 * @Date: 15:22 2018/9/18
 * @Desc:
 */
@RestController
@RequestMapping("main")
public class MainController {
    @Autowired
    private SparkFirstService sparkTestService;

    @RequestMapping("spark")
    public Map<String, Object> sparkDemo() {
        return sparkTestService.firstLearn();
    }
}
