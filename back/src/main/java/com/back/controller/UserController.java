package com.back.controller;

import com.back.entity.UserBo;
import com.back.service.IUserService;
import com.common.entity.Result;
import com.common.tools.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: gaodw
 * @Date: 15:21 2018/8/9
 * @Desc: 用户相关管理
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService iUserService;

    /**
     * 获得用户
     */
    @GetMapping
    public Result getAllUser(){
        try{
            List<UserBo> list = iUserService.getAllUser();
            return ResultTool.successWithList(iUserService.getAllUser());
        }catch(Exception ex){
            log.error(">>>>>getUser user has errors:",ex);
        }
        return ResultTool.failed();
    }
    /**
     * 获得用户
     */
    @PostMapping("one")
    public Result getOneUser(@RequestBody UserBo userBo){
        try{
            List<UserBo> list = iUserService.getOneUser(userBo);
            UserBo bo = null;
            if (list.size()>0){
                bo = list.get(0);
            }
            return ResultTool.successWithMap(bo);
        }catch(Exception ex){
            log.error(">>>>>getUser user has errors:",ex);
        }
        return ResultTool.failed();
    }

    /**
     * 保存或者更新用户信息
     */
    @PostMapping
    public Result save(@RequestBody UserBo userBo){
        try{
            iUserService.save(userBo);
            return ResultTool.success();
        }catch(Exception ex){
            log.error(">>>>>save user has errors:",ex);
        }
        return ResultTool.failed();
    }

    /**
     * 保存或者更新用户信息
     */
    @PutMapping
    public Result update(@RequestBody UserBo userBo){
        try{
            iUserService.update(userBo);
            return ResultTool.success();
        }catch(Exception ex){
            log.error(">>>>>update user has errors:",ex);
        }
        return ResultTool.failed();
    }

    /**
     * 删除用户信息
     */
    @DeleteMapping
    public Result delUser(@RequestBody UserBo userBo){
        try{
            iUserService.del(userBo);
            return ResultTool.success();
        }catch(Exception ex){
            log.error(">>>>>delete user has errors:",ex);
        }
        return ResultTool.failed();
    }

}
