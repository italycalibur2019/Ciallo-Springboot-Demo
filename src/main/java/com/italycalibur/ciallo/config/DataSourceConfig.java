package com.italycalibur.ciallo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
public class DataSourceConfig {
    @Bean(name = "sysDataSource")
    @ConfigurationProperties(prefix = "app.datasource.sys")
    public DataSource sysDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "app.datasource.basedata")
    public DataSource baseDataSource() {
        return DataSourceBuilder.create().build();
    }
}
