package com.view.controller;

import com.alibaba.fastjson.JSONObject;
import com.view.constant.PropertiesConstant;
import com.view.entity.jpa.UserBo;
import com.view.service.IUserService;
import com.view.tools.LoggerTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    PropertiesConstant userConstant;

    /**
     * 获得所有用户
     */
    @GetMapping("userConstant")
    public ResponseEntity<PropertiesConstant> getAllUser(){
        try{
            return ResponseEntity.ok(userConstant);
        }catch(Exception ex){
            log.error(">>>>>getAllUser user has errors:",ex);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
