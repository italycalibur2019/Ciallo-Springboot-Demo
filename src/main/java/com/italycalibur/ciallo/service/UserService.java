package com.italycalibur.ciallo.service;

import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.vo.UserInfoVO;

/**
 * @author dhr
 * @version 1.0
 * @description: TODO
 * @date 2024-12-13 下午5:52:07
 */
public interface UserService {
    UserInfoVO login(String username, String password);

    User register(RegisterDTO params);
}
