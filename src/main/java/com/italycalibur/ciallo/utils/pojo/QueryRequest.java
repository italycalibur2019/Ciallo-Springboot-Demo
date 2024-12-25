package com.italycalibur.ciallo.utils.pojo;

import com.italycalibur.ciallo.utils.SortsUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author dhr
 * @version 1.0
 * @description: 统一查询请求
 * @date 2024-12-24 上午9:01:01
 */
public record QueryRequest<T>(Integer pageNo, Integer pageSize, T params, List<OrderQuery> sorts) {
    public Pageable pageable() {
        return PageRequest.of(pageNo - 1, pageSize, sort());
    }

    public Sort sort() {
        return SortsUtils.makeSort(sorts());
    }

    @Getter
    @Setter
    public static class OrderQuery {
        private String field;
        private boolean isDesc;
    }
}
