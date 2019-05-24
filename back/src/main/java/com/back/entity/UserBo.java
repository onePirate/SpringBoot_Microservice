package com.back.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gaodw
 * @Date: 14:32 2018/8/9
 * @Desc:
 */
@Data
public class UserBo implements Serializable {

    private Long id;

    private String name;

    private int age;

    private String address;

    private String pwd;

}
