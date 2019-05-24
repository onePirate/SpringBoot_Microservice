package com.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaodw
 * @createTime 2019-05-24 1:01
 * @description
 */
@RestController
@RequestMapping
public class ConfigController {

    @GetMapping("get")
    public String getConfigByKey(String key){
        return "127.0.0.1:8080";
    }

}
