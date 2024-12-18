package com.italycalibur.ciallo.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: TODO 
 * @author dhr
 * @date 2024-12-14 上午8:22:27
 * @version 1.0
 */
@Data
public class UserInfo {
    private String avatar;

    private String username;

    private String nickname;

    private List<String> roles;

    private List<String> permissions;

    private String accessToken;

    private String refreshToken;

    private Date expires;
}
