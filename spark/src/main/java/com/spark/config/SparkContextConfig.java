package com.spark.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gwx556610
 * @Date: 15:24 2018/9/18
 * @Desc:
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="spark")
public class SparkContextConfig {


    private String sparkHome = ".";
    private String appName = "sparkTest";
    private String master = "local";

    @Bean
    @ConditionalOnMissingBean(SparkConf.class)
    private SparkConf sparkConf() {
        SparkConf conf = new SparkConf()
                .setSparkHome(sparkHome)
                .setAppName(appName)
                .setMaster(master);
        return conf;
    }

    @Bean
    @ConditionalOnMissingBean(JavaSparkContext.class)
    public JavaSparkContext javaSparkContext(){
        return new JavaSparkContext(sparkConf());
    }
}
