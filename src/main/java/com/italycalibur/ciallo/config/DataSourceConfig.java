package com.italycalibur.ciallo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @description: 多数据源配置
 * @author dhr
 * @date 2024-12-24 下午2:14:35
 * @version 1.0
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    @Primary
    @Bean(value = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.basedata")
    public DataSource baseDataSource() {
        log.info("Init baseDataSource");
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sysDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.sys")
    public DataSource sysDataSource() {
        log.info("Init sysDataSource");
        return DruidDataSourceBuilder.create().build();
    }

}
