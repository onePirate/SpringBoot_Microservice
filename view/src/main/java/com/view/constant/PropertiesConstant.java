package com.view.constant;

import com.view.entity.AddressPojo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: gaodawei
 * @Date: 2018/8/17 1:19
 * @Desc: 将配置文件中的每一个属性的值，映射到这个组件中
 * ‘@ConfigurationProperties’告诉SpringBoot将本类中的所有属性和配置文件中的相关的配置进行绑定，
 *      prefix = "constant"：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，容器才能提供@ConfigurationProperties功能
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "constant")
public class PropertiesConstant {

    private String LastName;
    private Integer age;
    private Boolean boss;
    private Date birthDay;

    private Map<String,Object> map;
    private List<Object> lists;
    private AddressPojo address;

}
