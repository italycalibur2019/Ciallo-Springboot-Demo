package com.italycalibur.ciallo.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @description: 持久层集合
 * @author dhr
 * @date 2024-12-24 上午9:07:44
 * @version 1.0
 */
@NoRepositoryBean
public interface BaseJpaDao<E extends BaseEntity, ID extends Serializable> extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
}
