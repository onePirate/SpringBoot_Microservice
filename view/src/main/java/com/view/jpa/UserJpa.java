package com.view.jpa;

import com.view.entity.jpa.UserBo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @Author: gwx556610
 * @Date: 17:01 2018/8/6
 * @Desc: 用户操作的jpa
 */
public interface UserJpa extends
        JpaRepository<UserBo,Long>,
        JpaSpecificationExecutor<UserBo>,
        Serializable {
}
