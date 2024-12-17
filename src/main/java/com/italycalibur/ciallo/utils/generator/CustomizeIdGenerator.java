package com.italycalibur.ciallo.utils.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @description: 自定义ID生成器
 * @author dhr
 * @date 2024-12-17 下午2:56:13
 * @version 1.0
 */ 
public class CustomizeIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return SnowFlakeUtils.snowflakeId();
    }
}
