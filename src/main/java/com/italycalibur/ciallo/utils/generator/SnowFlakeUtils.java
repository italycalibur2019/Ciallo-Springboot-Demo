package com.italycalibur.ciallo.utils.generator;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;

/**
 * @description: 雪花算法ID生成工具
 * @author dhr
 * @date 2024-12-17 下午3:02:08
 * @version 1.0
 */ 
public class SnowFlakeUtils {
    /**
     * 终端ID
     */
    public static long WORKER_ID = 1;

    /**
     * 数据中心id
     */
    public static long DATACENTER_ID = 1;

    private static final Snowflake snowflake = IdUtil.getSnowflake(WORKER_ID, DATACENTER_ID);

    @PostConstruct
    public void init() {
        WORKER_ID = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr()) >> 16 & 31;// 规定workerId范围在0L-31L之间
    }

    public static synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public static synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}
