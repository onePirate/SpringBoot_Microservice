package com.view.entity.jpa;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

/**
 * @Author: gaodw
 * @Date: 16:37 2018/8/6
 * @Desc:
 */
@Data
@Entity
@Table(name="t_user")
public class UserBo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    @Column(name = "t_pwd")
    private String pwd;

}
