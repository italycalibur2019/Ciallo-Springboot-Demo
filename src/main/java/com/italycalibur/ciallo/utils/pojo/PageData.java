package com.italycalibur.ciallo.utils.pojo;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author dhr
 * @version 1.0
 * @description: 分页返回参数
 * @date 2024-12-24 下午1:41:05
 */
public record PageData<T>(Integer page, Long total, List<T> rows, Integer totalPage, Map<String, Object> extraData) {

    public static <T> PageData<T> of(Integer page, Long total, List<T> rows, Integer totalPage) {
        return new PageData<>(page, total, rows, totalPage, null);
    }

    public static <T> PageData<T> of(Page<T> page) {
        return PageData.of(page.getNumber(), page.getTotalElements(), page.getContent(), page.getTotalPages());
    }

    public static <T> PageData<T> empty() {
        return PageData.of(0, 0L, List.of(), 0);
    }
}
