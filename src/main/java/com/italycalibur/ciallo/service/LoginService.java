package com.italycalibur.ciallo.service;

import com.italycalibur.ciallo.domain.sys.User;
import com.italycalibur.ciallo.dto.RefreshDTO;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.vo.RefreshVO;
import com.italycalibur.ciallo.vo.permission.RouterVO;
import com.italycalibur.ciallo.vo.UserInfo;

import java.util.List;

public interface LoginService {
    UserInfo login(String username, String password);

    User register(RegisterDTO params);

    RefreshVO refreshToken(RefreshDTO params);

    List<RouterVO> getAsyncRoutes();
}
