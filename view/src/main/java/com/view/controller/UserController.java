package com.view.controller;

import com.alibaba.fastjson.JSONObject;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService iUserService;

    /**
     * 简单测试请求日志的记录
     * @param request 请求对象
     * @param name 用户名
     * @return
     * @throws Exception
     */
    @PostMapping("login")
    public JSONObject login(HttpServletRequest request, String name)
    {
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+"，登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerTool.LOGGER_RETURN,obj);
        return obj;
    }

    /**
     * 获得所有用户
     */
    @GetMapping
    public ResponseEntity<List<UserBo>> getAllUser(){
        try{
            List<UserBo> list = iUserService.getAllUser();
            if (list==null || list.size()==0){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(list);
        }catch(Exception ex){
            log.error(">>>>>getAllUser user has errors:",ex);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 保存或者更新用户信息
     */
    @PostMapping
    public ResponseEntity<UserBo> saveOrUpdate(@RequestBody UserBo userBo){
        try{
            UserBo bo = iUserService.saveOrUpdate(userBo);
            if(bo == null){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(bo);
        }catch(Exception ex){
            log.error(">>>>>saveOrUpdate user has errors:",ex);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 删除用户信息
     */
    @DeleteMapping
    public ResponseEntity<Void> delUser(@RequestBody UserBo userBo){
        try{
            iUserService.delUser(userBo.getId());
            return ResponseEntity.ok().build();
        }catch(Exception ex){
            log.error(">>>>>delete user has errors:",ex);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
