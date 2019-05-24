package com.common.config.perporties;


import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author gaodw
 * @createTime 2019-05-24 22:47
 * @description
 */
public class AbstractConfigurationProcessor {

    @Autowired
    private ConfigurationListenerProcessor configurationListenerProcessor;

    public AbstractConfigurationProcessor() {
    }

    @PostConstruct
    public void init() {
        this.configurationListenerProcessor.setCenterValue(this);
    }

}
