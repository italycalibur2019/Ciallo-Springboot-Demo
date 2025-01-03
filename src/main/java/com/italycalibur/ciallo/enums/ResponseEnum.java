package com.italycalibur.ciallo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dhr
 * @version 1.0
 * @description: 返回状态码
 * @date 2024-12-14 上午8:31:29
 */
@AllArgsConstructor
@Getter
public enum ResponseEnum {
    SUCCESS("200", "操作成功"),
    FAIL("500", "操作失败"),
    UNAUTHORIZED("401", "未授权"),
    FORBIDDEN("403", "禁止访问");

    private final String code;

    private final String msg;
}
