package com.italycalibur.ciallo.config.db;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-24 下午2:19:45
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.italycalibur.ciallo.repository.basedata"},
        entityManagerFactoryRef = "basedataEntityManagerFactory",
        transactionManagerRef = "basedataTransactionManager"
)
public class BasedataConfig {
    @Resource(name = "baseDataSource")
    private DataSource baseDataSource;

    @Primary
    @Bean(name = "basedataEntityManager")
    public EntityManager basedataEntityManager(EntityManagerFactoryBuilder builder) {
        return basedataEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "basedataEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean basedataEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.hbm2ddl.auto", "none");
        map.put("hibernate.show_sql", "true");

        return builder
                .dataSource(baseDataSource)
                .properties(map)
                .packages("com.italycalibur.ciallo.domain.basedata")
                .persistenceUnit("basedataPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "basedataTransactionManager")
    public PlatformTransactionManager basedataTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(basedataEntityManagerFactory(builder).getObject());
    }
}
