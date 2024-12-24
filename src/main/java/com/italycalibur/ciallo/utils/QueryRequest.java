package com.italycalibur.ciallo.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author dhr
 * @version 1.0
 * @description: 统一查询请求
 * @date 2024-12-24 上午9:01:01
 */
public record QueryRequest<T>(Integer pageNo, Integer pageSize, T params) {
    public Pageable pageable() {
        return PageRequest.of(pageNo - 1, pageSize);
    }
}
