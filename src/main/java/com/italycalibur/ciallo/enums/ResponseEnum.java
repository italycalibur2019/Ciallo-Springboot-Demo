package com.italycalibur.ciallo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dhr
 * @version 1.0
 * @description: TODO
 * @date 2024-12-14 上午8:31:29
 */
@AllArgsConstructor
@Getter
public enum ResponseEnum {
    SUCCESS("200", "操作成功"),
    FAIL("500", "操作失败");

    private final String code;

    private final String msg;
}
