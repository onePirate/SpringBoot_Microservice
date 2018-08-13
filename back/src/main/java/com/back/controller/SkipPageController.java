package com.back.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class SkipPageController {

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
