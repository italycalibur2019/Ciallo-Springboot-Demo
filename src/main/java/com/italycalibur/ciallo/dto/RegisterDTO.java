package com.italycalibur.ciallo.dto;

import lombok.Data;

/**
 * @description: 注册参数
 * @author dhr
 * @date 2024-12-14 上午8:22:46
 * @version 1.0
 */
@Data
public class RegisterDTO {
    private String username;

    private String password;

    private String nickname;
}
