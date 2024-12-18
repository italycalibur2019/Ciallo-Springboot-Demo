package com.italycalibur.ciallo.controller;

import com.italycalibur.ciallo.domain.User;
import com.italycalibur.ciallo.dto.LoginDTO;
import com.italycalibur.ciallo.dto.RegisterDTO;
import com.italycalibur.ciallo.service.LoginService;
import com.italycalibur.ciallo.utils.Result;
import com.italycalibur.ciallo.vo.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 登录注册管理
 * @author dhr
 * @date 2024-12-13 下午5:57:30
 * @version 1.0
 */
@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 登录
     * @param params 登录参数
     * @return 用户信息
     */
    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody LoginDTO params) {
        UserInfo userInfo = loginService.login(params.getUsername(), params.getPassword());
        if (userInfo != null) {
            return Result.ok("登录成功！", userInfo);
        }else {
            return Result.fail("500", "用户名或密码错误！");
        }
    }

    /**
     * 注册
     * @param params 注册参数
     * @return Result<Object>
     */
    @PostMapping("/register")
    public Result<Object> register(@RequestBody RegisterDTO params) {
        User register = loginService.register(params);
        if (register != null) {
            return Result.ok("注册成功！");
        }else {
            return Result.fail("500", "注册失败！");
        }
    }
}
