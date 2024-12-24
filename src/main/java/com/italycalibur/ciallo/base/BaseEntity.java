package com.italycalibur.ciallo.base;

import com.italycalibur.ciallo.utils.generator.SnowFlakeIdGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: 实体基类
 * @author dhr
 * @date 2024-12-17 下午2:51:11
 * @version 1.0
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(generator = "idGenerator")
    @SnowFlakeIdGenerator(name = "idGenerator")
    private Long id;

}
