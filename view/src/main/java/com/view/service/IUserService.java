package com.view.service;

import com.view.entity.jpa.UserBo;

import java.util.List;

public interface IUserService {
    /**
     * 获得所有的用户列表
     * @return
     */
    List<UserBo> getAllUser();
    /**
     * 保存
     * @return
     */
    UserBo saveOrUpdate(UserBo userBo);
    /**
     * 删除
     */
    void delUser(Long id);
}
