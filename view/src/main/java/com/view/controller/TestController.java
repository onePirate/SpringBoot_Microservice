package com.view.controller;

import com.view.constant.PropertiesConstant;
import com.view.properties.RabbitMQModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            log.info(">>>>>idea create temp branch handle bug,true dev branch add log test merge");
            log.info(">>>>>idea create temp branch handle bug,dev develop 1");
            log.info(">>>>>idea create temp branch handle bug,dev develop 2");
            log.info(">>>>>idea create temp branch handle bug,check head commit where branch");
            log.info(">>>>>every start should be head");
            return ResponseEntity.ok(userConstant);
        }catch(Exception ex){
            log.error(">>>>>getAllUser user has errors:",ex);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Autowired
    RabbitMQModel rabbitMQModel;

    @GetMapping("getConfig")
    public RabbitMQModel getRabbitMQModel(){
        return rabbitMQModel;
    }

}
