package com.view.service.impl;

import com.view.entity.jpa.UserBo;
import com.view.jpa.UserJpa;
import com.view.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserJpa userJpa;

    @Override
    public List<UserBo> getAllUser() {
        return userJpa.findAll();
    }

    @Override
    public UserBo saveOrUpdate(UserBo userBo) {
        return userJpa.save(userBo);
    }


    @Override
    public void delUser(Long id) {
        userJpa.deleteById(id);
    }

}
