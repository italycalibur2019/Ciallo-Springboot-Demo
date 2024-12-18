package com.italycalibur.ciallo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author dhr
 * @version 1.0
 * @date 2024-12-18 21:46:00
 * @description: TODO
 */
@Data
public class RefreshVO {
    private String accessToken;

    private String refreshToken;

    private Date expires;
}
