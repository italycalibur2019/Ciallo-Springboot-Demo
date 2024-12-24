package com.italycalibur.ciallo.dto;

import lombok.Data;

/**
 * @description: 车手查询参数
 * @author dhr
 * @date 2024-12-24 下午3:27:56
 * @version 1.0
 */
@Data
public class DriverSearchDTO {

    private String firstName;

    private String lastName;

    private Integer code;

    private String country;

}
