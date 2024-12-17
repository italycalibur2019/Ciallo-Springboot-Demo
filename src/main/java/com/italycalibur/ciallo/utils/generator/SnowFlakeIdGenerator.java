package com.italycalibur.ciallo.utils.generator;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dhr
 * @version 1.0
 * @description: 自定义ID生成注解
 * @date 2024-12-17 下午3:07:05
 */
@IdGeneratorType( CustomizeIdGenerator.class )
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention( RetentionPolicy.RUNTIME )
public @interface SnowFlakeIdGenerator {
    String name();
}
