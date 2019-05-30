package com.view.properties;

import com.configmng.AbstractConfigurationProcessor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gaodw
 * @createTime 2019-05-24 22:45
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "rmq")
public class RabbitMQModel extends AbstractConfigurationProcessor {

    private String rabbitIp;

}
