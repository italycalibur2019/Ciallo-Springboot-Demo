package com.italycalibur.ciallo.utils;

import com.italycalibur.ciallo.utils.pojo.QueryRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: JPA排序对象工具
 * @author dhr
 * @date 2024-12-25 上午10:43:57
 * @version 1.0
 */ 
public class SortsUtils {
    public static Sort makeSort(List<QueryRequest.OrderQuery> sorts) {
        List<Sort.Order> orders = new ArrayList<>();
        for (QueryRequest.OrderQuery sort : sorts) {
            orders.add(new Sort.Order(sort.isDesc() ? Sort.Direction.DESC : Sort.Direction.ASC, sort.getField()));
        }
        return Sort.by(orders);
    }
}
