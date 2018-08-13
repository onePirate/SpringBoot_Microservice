package com.back.mybatis;

import com.back.entity.UserBo;

import java.util.List;

/**
 * @Author: gwx556610
 * @Date: 13:41 2018/8/9
 * @Desc:
 */
public interface UserDao {

    List<UserBo> findUser(Long id);

    void save(UserBo userBo);

    void update(UserBo userBo);

    void delete(Long id);
}
