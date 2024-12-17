package com.italycalibur.ciallo.utils;

import com.italycalibur.ciallo.enums.ResponseEnum;

/**
 * @author dhr
 * @version 1.0
 * @description: 统一返回接口
 * @date 2024-12-14 上午8:27:32
 */
public record Result<T>(boolean success, String code, String message, T data) {
    public static <T> Result<T> ok(T data) {
        return new Result<>(true, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> ok(String message, T data) {
        return new Result<>(true, ResponseEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> fail(String code, String message) {
        return new Result<>(false, code, message, null);
    }

    public static <T> Result<T> fail(ResponseEnum responseEnum) {
        return new Result<>(false, responseEnum.getCode(), responseEnum.getMsg(), null);
    }
}
