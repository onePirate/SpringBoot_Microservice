package com.back.service;

import com.back.entity.UserBo;

import java.util.List;

/**
 * @Author: gaodw
 * @Date: 14:34 2018/8/9
 * @Desc: 用户的相关操作
 */
public interface IUserService {

    /**
     * 获取所有用户
     * @return
     */
    List<UserBo> getAllUser();

    /**
     * 获取一个用户
     * @param userBo
     * @return
     */
    List<UserBo> getOneUser(UserBo userBo);

    /**
     * 保存用户信息
     * @param userBo
     */
    void save(UserBo userBo);
    /**
     * 更新用户信息
     * @param userBo
     */
    void update(UserBo userBo);
    /**
     * 删除用户信息
     * @param userBo
     */
    void del(UserBo userBo);
}
