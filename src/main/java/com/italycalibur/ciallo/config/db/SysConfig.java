package com.italycalibur.ciallo.config.db;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @description: postgres sys模式具体配置
 * @author dhr
 * @date 2024-12-24 下午2:19:45
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.italycalibur.ciallo.repository.sys"},
        entityManagerFactoryRef = "sysEntityManagerFactory",
        transactionManagerRef = "sysTransactionManager"
)
public class SysConfig {
    @Resource
    private JpaProperties jpaProperties;
    @Resource
    private HibernateProperties hibernateProperties;
    @Resource(name = "sysDataSource")
    private DataSource sysDataSource;

    @Bean(name = "sysEntityManager")
    public EntityManager sysEntityManager(EntityManagerFactoryBuilder builder) {
        return sysEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "sysEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean sysEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(sysDataSource)
                .properties(jpaProperties.getProperties())
                .properties(getVendorProperties())
                .packages("com.italycalibur.ciallo.domain.sys")
                .persistenceUnit("sysPersistenceUnit")
                .build();
    }

    private Map<String, Object> getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "sysTransactionManager")
    public PlatformTransactionManager sysTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(sysEntityManagerFactory(builder).getObject());
    }
}
