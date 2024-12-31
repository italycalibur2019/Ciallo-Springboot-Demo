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

    /**
     * 返回空的分页结果
     * @return PageData<T>
     * @param <T> 泛型
     */
    public static <T> PageData<T> empty() {
        return new PageData<>(0, 0L, List.of(), 0, Map.of());
    }

    /**
     * 返回分页结果和额外参数
     * @param page 当前页码
     * @param total 总条数
     * @param rows 数据
     * @param totalPage 总页数
     * @param extraData 额外参数
     * @return PageData<T>
     * @param <T> 泛型
     */
    public static <T> PageData<T> of(Integer page, Long total, List<T> rows, Integer totalPage,  Map<String, Object> extraData) {
        return new PageData<>(page, total, rows, totalPage, extraData);
    }

    /**
     * 将Page对象转换为带额外参数的PageData对象
     * @param page Page对象
     * @param extraData 额外参数
     * @return PageData<T>
     * @param <T> 泛型
     */
    public static <T> PageData<T> of(Page<T> page, Map<String, Object> extraData) {
        return PageData.of(page.getNumber(), page.getTotalElements(), page.getContent(), page.getTotalPages(), extraData);
    }

    /**
     * 返回分页结果
     * @param page 当前页码
     * @param total 总条数
     * @param rows 数据
     * @param totalPage 总页数
     * @return PageData<T>
     * @param <T> 泛型
     */
    public static <T> PageData<T> of(Integer page, Long total, List<T> rows, Integer totalPage) {
        return PageData.of(page, total, rows, totalPage, Map.of());
    }

    /**
     * 将Page对象转换为PageData对象
     * @param page Page对象
     * @return PageData<T>
     * @param <T> 泛型
     */
    public static <T> PageData<T> of(Page<T> page) {
        return PageData.of(page, Map.of());
    }

}
